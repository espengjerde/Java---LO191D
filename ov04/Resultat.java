/*Resultat.java*/

class Resultat implements java.io.Serializable{
  private final String fagnr;
  private final String fagnavn;
  private int antStudiepoeng;
  private char[] karakterer;
  
  public Resultat(String fagnr, String fagnavn, int antStudiepoeng, char[] karakterer){
    this.fagnr = fagnr;
    this.fagnavn = fagnavn;
    this.antStudiepoeng = antStudiepoeng;
    this.karakterer = karakterer;
  }
  
  public String toString(){
    String kar = "";
    for(char karakter : karakterer){
      kar += karakter + ", ";
    }
    return fagnr + ", " + fagnavn + ", " + antStudiepoeng + ", " + kar;
  }
  
}
