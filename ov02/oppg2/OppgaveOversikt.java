/*OppgaveOversikt.java*/

import java.util.ArrayList;

class OppgaveOversikt{
  private ArrayList<Student> studenter = new ArrayList<Student>();
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
    for(Student student : studenter)
      if(namn.equals(student.getNavn())) svar = student.getAntOppg();
    return svar;
  }
  /*
  * Returnerer en string-tabell med navna på alle studentene;
  */
  public String[] finnAlleNavn(){
    String[] navneliste = new String[studenter.size()];
    for(Student student : studenter)
      navneliste[studenter.indexOf(student)] = student.getNavn();
    return navneliste;
  }
  /* 
  * Registrerer ny student og øker størrelesen på student-tabellen.
  */
  public boolean regNyStudent(String namn){
    for(Student student : studenter){
      if(namn.equals(student.getNavn())) return false;
    }
    studenter.add(new Student(namn));
    antStud++;
    return true;
  }
  
  /*
  * Tek (String) namn og (int) tal som argument. Øker antall godkjente oppgaver for student med talet.
  */
  public boolean økAntOppg(String namn, int leggTil){
    for(Student student : studenter){
      if(namn.equals(student.getNavn())){
        leggTil += student.getAntOppg();
        student.setAntOppg(leggTil);
        return true;
      }
    }
    return false;
  }

  public String toString(){
    String tekst = "Studenter i oversikten: \n";
    for(Student student : studenter) tekst += student + "\n";
    return tekst;
  }
}
