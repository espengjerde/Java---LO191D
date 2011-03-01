/*KonferansesenterUI.java*/
import static javax.swing.JOptionPane.*;

class KonferansesenterUI{
  public static void main(String[] args){
    Konferansesenter ks = new Konferansesenter();

    String[] MENY = {"Opprett rom", "Reserver rom", "Søk etter Rom", "Vis all info", "Avslutt"};

    boolean avslutt = false;
    while(!avslutt){
    int valg = showOptionDialog(null, "Where do you want to reserve today?", "Konferansesenter", 0, PLAIN_MESSAGE, null, MENY, MENY[1]);
      switch(valg){
        case 0:
          int plasser = Integer.parseInt(showInputDialog("Antall plasser i rommet?", "16"));
          int romnr = ks.nyttRom(plasser);
          showMessageDialog(null,"Rom " + romnr + " registrert, med " + plasser + " plasser.");
          break; 
        case 1:
          String namn = showInputDialog("Skriv namn på kunde", "Kunde Kundesen");
          String tlf = showInputDialog("Skriv tlf", "98877665");
          int plass = Integer.parseInt(showInputDialog("Antall plasser?", "10"));
          long fra = Long.parseLong(showInputDialog("Fra?","201101010900"));
          long til = Long.parseLong(showInputDialog("Til?","201101012000"));
          if(ks.reserver((new Kunde(namn,tlf)), fra, til, plass)){
            showMessageDialog(null,"Reservasjon er ok.");
          } else{
            showMessageDialog(null,"Noko gjekk gale.");
          }
          break;
        case 2:
          int nummer = Integer.parseInt(showInputDialog("Romnummer?", "0"));
          Rom rom = ks.getRom(nummer);
          if(rom.getPlass() < 0){
            showMessageDialog(null, "Romnr. " + nummer + " eksisterer ikkje");
          }
          else{
            showMessageDialog(null, rom);
          }
          break;
        case 3:
          showMessageDialog(null, ks);
          break;
        case 4:
          avslutt = true;
          break;
      }
    }
  }
}
