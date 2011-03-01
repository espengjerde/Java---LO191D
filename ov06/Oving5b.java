/*Oving5b.java*/
import java.sql.*;
import static javax.swing.JOptionPane.*;

class Oving5b{
  public static void main(String[] args) throws Exception{
    
    Connection con = DBC.conStd(); //DBC.java må ligge i samme mappe.
    
    Statement st = con.createStatement();
  
    boolean avslutt = false;  
    while(!avslutt){
      String laaner = showInputDialog("Oppgi namn på låner","Donald Duck");
      String isbn = showInputDialog("Kva bok vil "+laaner+" låne?", "0-07-241163-5");
      int id = Integer.parseInt(showInputDialog("Skriv inn boknummer.","1"));
      
      
      String query = "UPDATE eksemplar SET laant_av='"+laaner+"' WHERE isbn='"+isbn+"' AND eks_nr="+id+" AND laant_av IS NULL";
      
      if(st.executeUpdate(query) > 0){
        showMessageDialog(null, laaner+" er no registrert som låner av\n"+id+". eksemplaret av "+isbn);
      } else { showMessageDialog(null, "Noko gjek gale."); }
      
      int valg = showConfirmDialog(null, "Vil du avslutte?", "SUPER-BOK 2011", YES_NO_OPTION);

      avslutt = (valg > 0) ? false : true;
    }
    
    st.close();
    Statement status = con.createStatement();
    String query = "select * from eksemplar order by isbn, eks_nr asc";
    ResultSet tabell = status.executeQuery(query);
    System.out.println("ISBN           EKS_NR   LAANT_AV");
    while(tabell.next()){
      String isbn = tabell.getString("isbn");
      int id = tabell.getInt("eks_nr");
      String laaner = tabell.getString("laant_av");
      System.out.println(isbn + "     " + id + "     " + laaner);
    }
    tabell.close();
    status.close();
    con.close();
  }
}
