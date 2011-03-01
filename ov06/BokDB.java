/*BokDB.java*/
import java.sql.*;

class BokDB {
  private final DB db = new DB("persondata","vprg","vprg");

  private int sjekkAntall(String isbn){
    if(isbn == null) return -1;
    int antall = 0; 
    String query = "SELECT count(*) antall FROM eksemplar WHERE isbn ='"+isbn+"'";
    System.out.println("QUERY: "+query);
    Statement stm = null;
    ResultSet res = null;
    try{
        stm = db.nySTM();

        res = stm.executeQuery(query);
        res.next();
        antall = res.getInt("antall");

    }
    catch(SQLException se){
      System.out.println("DB-feil: Feil ved sjekk av antall.\n"+se);
     return -2;
   }
    finally{
      db.lukkRS(res);
      db.lukkSTM(stm);
    }
    return antall;
  }
  
  public boolean regNyBok(Bok nyBok){  
    String tittel = nyBok.getTittel();
    String isbn = nyBok.getIsbn();
    String forfatter = nyBok.getForfatter();
    
    if(!(sjekkAntall(isbn) == 0)) return false;
    String[] oppdatter = {"INSERT INTO boktittel(isbn, forfatter, tittel) VALUES('"+isbn+"', '"+forfatter+"', '"+tittel+"')",
                          "INSERT INTO eksemplar(isbn, eks_nr) VALUES ('"+isbn+"', 1)"};

    System.out.println("qBoktittel: "+oppdatter[0]+"\nqEksemplar: "+ oppdatter[1]);  
    
    return db.tryUpdate(oppdatter);
      
  }
  
  public boolean regNyttEksamplar(String isbn){
    if(!(isbn != null && sjekkAntall(isbn) > 0)) return false;
    int eksNr = sjekkAntall(isbn) + 1;
    
    String[] update = {"INSERT INTO eksemplar(isbn, eks_nr) VALUES ('"+isbn+"', "+eksNr+")"};
    System.out.println(update[0]);
    return db.tryUpdate(update);
  }
  
  public boolean lånUtEksemplar(String låner, String isbn, int nr){
    if(isbn == null || sjekkAntall(isbn) == 0 || nr > sjekkAntall(isbn)) return false;
    
    String[] update = {"UPDATE eksemplar SET laant_av = '"+låner+"' WHERE isbn = '"+isbn+"' AND eks_nr = "+nr+" "};
    System.out.println(update[0]);

    return db.tryUpdate(update);
  }
  public void lukkDB(){
    db.lukkForbindelse();
  } 
}
