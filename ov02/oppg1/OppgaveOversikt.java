/*OppgaveOversikt.java*/
class OppgaveOversikt{
  private Student[] studenter = new Student[1];
  private int antStud;

//Klassa benytter seg av standardkonstruktør.  
    
  public int finnAntStud(){
    return antStud;
  }
  
  /*
  * Tek (String) namn som argument og returnerer (int) antall oppgaver for student med samme namn.
  */
  public int finnAntOppgaver(String namn){
    int svar = 0;
    for(int i = 0; i < studenter.length; i++){ 
      if(namn.equals(studenter[i].getNavn())){
        svar = studenter[i].getAntOppg();
        break;
      }
    }
    return svar;
  }
  
  /*
  * Returnerer en string-tabell med navna på alle studentene;
  */
  public String[] finnAlleNavn(){
    String[] navneliste = new String[studenter.length];
    for(int i = 0; i < studenter.length; i++){
//      if(studenter[i] == null) break;
      navneliste[i] = studenter[i].getNavn();
    }
    return navneliste;
  }
  
  /* 
  * Registrerer ny student og øker størrelesen på student-tabellen.
  */
  public boolean regNyStudent(String namn){
    for(int i = 0; i < studenter.length; i++){
      if(studenter[i] != null && namn.equals(studenter[i].getNavn())) return false; //
    }
//    if(studenter[(studenter.length - 1)] != null){
      Student[] nyStudTab = new Student[(antStud + 1)];
      for(int i = 0; i < studenter.length; i++){
        nyStudTab[i] = studenter[i];
      }
      studenter = nyStudTab;
      
//    }
    studenter[antStud] = new Student(namn);
    antStud++;
    return true;
  }
  
  /*
  * Tek (String) namn og (int) tal som argument. Øker antall godkjente oppgaver for student med talet.
  */
  public boolean økAntOppg(String namn, int leggTil){
    for(int i = 0; i < studenter.length; i++){
      if(namn.equals(studenter[i].getNavn())){
        int oppg = studenter[i].getAntOppg() + leggTil;
        studenter[i].setAntOppg(oppg);
        return true;
      }
    }
    return false;
  }

  public String toString(){
    String tekst = "Studenter i oversikten: \n";
    for(int i = 0; i < studenter.length; i++){
      tekst += studenter[i] + "\n";
    }
    return tekst;
  }
}
