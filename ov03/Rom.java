import java.util.ArrayList;

/*Rom.java*/

class Rom{
  private int romnr;
  private int plass;
  private ArrayList<Reservasjon> res = new ArrayList<Reservasjon>();
  
  public Rom(int romnr, int plass){
    this.romnr = romnr;
    this.plass = plass;
  }
  
  public int getRomNr(){
    return romnr;
  }
  public int getPlass(){
    return plass;
  }
  
  /*
  * sjekker om rommet er ledig i tidspunktet, og reserverer om tidspunktet er ledig.
  */
  public boolean reserver(long fraL, long tilL, Kunde kunde){
    Tidspunkt fra = new Tidspunkt(fraL);
    Tidspunkt til = new Tidspunkt(tilL);
    for(Reservasjon tid : res){
     if(tid.overlapp(fra, til)) return false;
    }
    res.add(new Reservasjon(fra, til, kunde));
    return true;
  }

  public String toString(){
    String tekst = "Rom nr. " + romnr + ", "+ plass + " plasser. \nReservasjoner: \n";
    for(Reservasjon tid : res){
      tekst += "F: " + tid.getFraTid() + "   T: " + tid.getTilTid() + "\n";
    }
    return tekst;
  }
  
  /*
  * Testmetode for klassa Rom.
  */
  public static void main(String[] args){
    Rom rom = new Rom(0,16);
    Kunde kunde = new Kunde("Kunde Kundesen", "98765432");

    System.out.println("Utfører fire tester:");
    if(rom.reserver(201101010800L, 201101010900L, kunde)) System.out.println("Test 1: OK");
    if(!rom.reserver(201101010800L, 201101010900L, kunde)) System.out.println("Test 2: OK");
    if(rom.reserver(201101010901L, 201101011000L, kunde)) System.out.println("Test 3: OK");
    if(rom.reserver(201101011000L, 201101011100L, kunde)) System.out.println("Test 4: OK");
    System.out.println();
    System.out.println(rom);
  } 
}
