/*Student.java*/
class Student{
  private final String navn;
  private int antOppg;

  public Student(String navn){
    this.navn = navn;
  }

  public String getNavn(){
    return navn;
  }
  
  public int getAntOppg(){
    return antOppg;
  }
  
  public void setAntOppg(int antOppg){
    if(antOppg > 0){
      this.antOppg = antOppg;
    }
    else{
      throw new IllegalArgumentException("Kan ikkje ha negativt tal som argument");
    }
  }
  
  public String toString(){
    return navn + " har " + antOppg + " godkjente oppgaver.";
  }
}
