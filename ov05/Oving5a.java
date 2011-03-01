/* Oving5a.java */

import java.sql.*;
import static javax.swing.JOptionPane.*;

class Oving5a {
  public static void main(String[] args) throws Exception{

    Connection forbindelse = DBC.conStd(); //"DBC.java" må ligge i samme mappe.
    Statement qBoktittel = forbindelse.createStatement();
    Statement qEksemplar = forbindelse.createStatement();
    
    String isbn = showInputDialog("Skriv inn isbn-nummer","0-201-50998-X");
    
    String queryBoktittel = "SELECT forfatter, tittel FROM boktittel WHERE isbn='"+isbn+"'";
    String queryEksemplar = "SELECT count(*) antall FROM boktittel WHERE isbn='"+isbn+"'";
    
    ResultSet resB = qBoktittel.executeQuery(queryBoktittel);
    ResultSet resE = qEksemplar.executeQuery(queryEksemplar);
    
    while (resB.next() && resE.next()) {
      int antall = resE.getInt("antall");
      String forfatter = resB.getString("forfatter");
      String tittel = resB.getString("tittel");
      System.out.println("ISBN"+isbn+":\n"+tittel+" av "+forfatter+": "+antall+" stk.");
    }
    resB.close();
    resE.close();
    qBoktittel.close();
    qEksemplar.close();
    forbindelse.close();
  }
}

/* Utskrift fra programmet:
100: Ole Hansen
101: Anne Grethe Ås
102: Jonny Hansen
*/

