/*Oving.java*/

import static javax.swing.JOptionPane.*;

class Oving6{
  public static void main(String[] args){
    
    BokDB db = new BokDB();
    final String[] MENYVAL = {"Registrer ny bok", "Registrer nytt eksemplar", "Lån ut bok", "avslutt"};

    boolean avslutt = false;
    
    while(!avslutt){
    int val = showOptionDialog(null, "What do you want to read today?", "Bokorm Biblioteksystem 1.0", 0, PLAIN_MESSAGE, null, MENYVAL, MENYVAL[0]);
    switch(val){
    case 0:
      String tittel = showInputDialog("Skriv tittel","Java-4-Ever");
      String forfatter = showInputDialog("Skriv forfatter for "+tittel,"Lenny Linux");
      String isbn = showInputDialog("ISBN for "+tittel+" av"+forfatter, "1");
      if(db.regNyBok(new Bok(isbn, tittel, forfatter))) {
        showMessageDialog(null,"WHOHOO! itz naow in ur db!");
      }
      else{
        showMessageDialog(null,"lol. Fail.");
      }
      break;
    case 1:
      isbn = showInputDialog("Give me ur iZbN plz","1");
      if(db.regNyttEksamplar(isbn)){
        showMessageDialog(null,"WHOHOO! itz naow i++ in ur db!");
      }
      else{
        showMessageDialog(null,"lol. Fail.");
      }
      break;
    case 2:
      String låner = showInputDialog("Namn","Jean-Luc Picard");
      isbn = showInputDialog("ISBN:","1");
      int nr = Integer.parseInt(showInputDialog("Eks_nr","1"));
      if(db.lånUtEksemplar(låner, isbn, nr)){
        showMessageDialog(null,"Boka er lånt ut.");
      }
      else{
        showMessageDialog(null,"lol. Fail.");
      }
      break;
    case 3:
      avslutt = true;
      break;
    }
    
    }
   db.lukkDB();
  }
}
