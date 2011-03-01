

import java.sql.*;

class DBC{
  
  public Connection conDB(String db, String user, String pass) throws Exception {
    String databasedriver = "org.apache.derby.jdbc.ClientDriver";
    Class.forName(databasedriver);  // laster inn driverklassen

    String databasenavn = "jdbc:derby://localhost:1527/"+db+";user="+user+";password="+pass+"";
    Connection forbindelse = DriverManager.getConnection(databasenavn);
    
    return forbindelse; 
   }
  
  public static Connection conStd() throws Exception {
    String databasedriver = "org.apache.derby.jdbc.ClientDriver";
    Class.forName(databasedriver);  // laster inn driverklassen

    String databasenavn = "jdbc:derby://localhost:1527/persondata;user=vprg;password=vprg";
    Connection forbindelse = DriverManager.getConnection(databasenavn);
    
    return forbindelse;
  }
  /*
  public static void ResultSet(res){
    try{
      res.close()
    }
    catch(SQLExceptio sqle){
      System.out.println("Feil ved lukking av ResultSet" + sqle);
    }
  }
  */
}
