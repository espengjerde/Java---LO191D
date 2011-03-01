/*Bord.java*/

class Bord {
  private String[] bord;
  private int antBord;
  
  public Bord(int antallBord){
    bord = new String[antallBord];
    antBord = bord.length;
  }
  
  /*Reserverer første ledige bord på namn*/
  public void reserverBord(String namn){
    for(int i = 0; i < antBord; i++){
      if(bord[i] != null){
      }
      else{
        bord[i] = namn;
        break;
      }
    }
  }
  
  public String[] getBordListe(){
    return bord;
  }
  
  public int getAntallBord(){
    return bord.length;
  }
  
  /* Sett bordet som ledig */
  public void ryddBord(int bordNr){
    bord[bordNr] = null;
  }
  
  /* Sjekker kor mange bord som er ledige. Returnerer antall ledige-*/
  public int getLedige(){
    int antall = 0;
    for(int i = 0; i < bord.length; i++){
      if(bord[i] == null) antall++;
    }
    return antall;
  }
  /* Sjekker kor mange bord som er ledige. Returnerer antall reserverte-*/
  public int getReserverte(){
    return (antBord - getLedige());
  }

  private int getReservertePrPers(String namn){
    int antall = 0;
    for(int i = 0; i < getLedige(); i++){
      if(bord[i] == namn) antall++;
    }
    return antall;
  }
  
  public int[] getReservasjoner(String namn){
    int[] liste = new int[getReservertePrPers(namn)];
    int ant = 0;
    for(int k = 0; k < liste.length; k++){
      for(int i = 0; i < bord.length; i++){
        if(bord[i] == namn){
        liste[k] = i;
        break;
        }
      }
    }
    return liste;
  }
  
}
