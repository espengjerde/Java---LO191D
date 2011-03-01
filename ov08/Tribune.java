/*Tribune.java*/
import java.util.ArrayList;
//abstract class Tribune implements java.io.Serializable{
abstract class Tribune implements java.lang.Comparable<Tribune>{
  private final String tribuneNavn;
  private final int kapasitet;
  private final int pris;

  public Tribune(String tribuneNavn, int kapasitet, int pris) {
    this.tribuneNavn = tribuneNavn;
    this.kapasitet = kapasitet;
    this.pris = pris;
  }
  public String getTribuneNavn(){
    return tribuneNavn;
  }
  public int getKapasitet(){
    return kapasitet;
  }
  public int getPris(){
    return pris;
  }
  
  public abstract int getAntallSolgte();
  public abstract int getInntekt();
  public abstract ArrayList<Billett> kjøpBilletter(String[] navn);
  public abstract ArrayList<Billett> kjøpBilletter(int antall);
  
  public String toString(){
    return getTribuneNavn() + " har " + getKapasitet() + " plasser. \n Det er solgt " + getAntallSolgte() + " biletter. \n Inntekt: kr."+getInntekt()+",-\n";
  }
  public int compareTo(Tribune annaObjekt){
    int a = this.getInntekt();
    int b = annaObjekt.getInntekt();
    return (a < b) ? -1 : 1;
  }

}

class Staa extends Tribune{
  private int antSolgte;
  
  public Staa(String tribuneNavn, int kapasitet, int pris){
    super(tribuneNavn, kapasitet, pris);
    antSolgte = 0;
  }
  public boolean selgStaa(int antBiletter){
    return antSolgte++ <= getKapasitet() ? true : false;
  }

  public int getAntallSolgte(){
    return antSolgte; 
  }
  public int getInntekt(){
    return getPris()*antSolgte;
  }
  
  public ArrayList<Billett> kjøpBilletter(String[] navn){
    if((navn.length + antSolgte) > getKapasitet()){
      throw new IllegalArgumentException("Ikkje nok ledige plassar.");
    }
    ArrayList<Billett> billetter = new ArrayList<Billett>();
    for(String tilskuer : navn){
      billetter.add(new StaaplassBillett(getTribuneNavn(), getPris()));
      antSolgte++;
    }
    return billetter;
  }
  public ArrayList<Billett> kjøpBilletter(int antall){
    if((antall + antSolgte) > getKapasitet()){
      throw new IllegalArgumentException("Ikkje nok ledige plassar.");
    }
    ArrayList<Billett> billetter = new ArrayList<Billett>();
    for(int i = 0; i < antall; i++){
      billetter.add(new StaaplassBillett(getTribuneNavn(), getPris()));
      antSolgte++;
    }
    return billetter;
  }
}

class Sitte extends Tribune{
  private int[] antOpptatt;
  private int rekkeLengde;
  
  public Sitte(String tribuneNavn, int pris, int x, int y){
    super(tribuneNavn, x*y, pris);
    antOpptatt = new int[y];
    rekkeLengde = x;
  }
  public int getAntallSolgte(){
    int solgte = 0;
    for(int opptatte : antOpptatt){
      solgte += opptatte;
    }
    return solgte;
  }
  public int getInntekt(){
    return getPris()*getAntallSolgte();
  }
  
  private int ledig(int antall){
    int rekke = -1;
    for(int i = 0; i < antOpptatt.length; i++){
      if((antOpptatt[i] + antall) <= rekkeLengde) rekke = i;
    }
    return rekke;
  }
  
  public ArrayList<Billett> kjøpBilletter(String[] navn){
    int rekke = ledig(navn.length);
    if(rekke < 0){
      throw new IllegalArgumentException("Ikkje nok ledige plassar.");
    }
    ArrayList<Billett> billetter = new ArrayList<Billett>();
    for(String tilskuer : navn){
      antOpptatt[rekke]++;
      billetter.add(new SitteplassBillett(getTribuneNavn(), getPris(), rekke, antOpptatt[rekke]));
    }
    return billetter;
  }
  public ArrayList<Billett> kjøpBilletter(int antall){
    int rekke = ledig(antall);
    if(rekke < 0){
      throw new IllegalArgumentException("Ikkje nok ledige plassar.");
    }
    ArrayList<Billett> billetter = new ArrayList<Billett>();
    for(int i = 0; i < antall; i++){
      antOpptatt[rekke]++;
      billetter.add(new SitteplassBillett(getTribuneNavn(), getPris(), rekke, antOpptatt[rekke]));
    }
    return billetter;
  }
}
class VIP extends Tribune{
  private String[][] tilskuer;
  
  public VIP(String tribuneNavn, int pris, int x, int y){
    super(tribuneNavn, x*y, pris);
    tilskuer = new String[x][y];
  }

  private int ledig(int antall){
    int rekke = -1;
    for(int i = 0; i < tilskuer.length; i++){
      if(antall <= tilskuer[i].length && tilskuer[i][0] == null) rekke = i;
    }
    return rekke;
  }
  
  public ArrayList<Billett> kjøpBilletter(String[] navn){
    int rekke = ledig(navn.length);
    if(rekke < 0){
      throw new IllegalArgumentException("Ingen ledige plassar");
    }
    ArrayList<Billett> billetter = new ArrayList<Billett>();

    for(int i = 0; i < navn.length; i++){
      tilskuer[rekke][i] = navn[i];
      billetter.add(new SitteplassBillett(getTribuneNavn(), getPris(), rekke, i)); 
    }
    return billetter;
  }
  public ArrayList<Billett> kjøpBilletter(int antall){
    throw new IllegalArgumentException("Vi sel ikkje VIP-billettar til kven som helst...");
  }
  public int getInntekt(){
    return getAntallSolgte()*getPris();
  }
  public int getAntallSolgte(){
    int antall = 0;
    for(int r = 0; r < tilskuer.length; r++){
      for(int c = 0; c < tilskuer[r].length; c++){
        if(tilskuer[r][c] != null) antall ++;
      }
    }
    return antall;
  }
}
