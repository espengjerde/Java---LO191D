/*LesData.java*/

import java.util.*;
import java.io.*;

class LesData implements java.io.Serializable{
  public static void main(String[] args) throws IOException {
 
    ArrayList<Resultat> resultater = new ArrayList<Resultat>();
    
    FileReader lesestrom = new FileReader("datafil");
    BufferedReader les = new BufferedReader(lesestrom);
    
    String linje = les.readLine();
    
    while(linje != null){
      StringTokenizer ordST = new StringTokenizer(linje, ",");
      ArrayList<String> ordAL = new ArrayList<String>();
      int ant = 0;
      while(ant < 3){
          ordAL.add(new String(ordST.nextToken().trim()));
          ant++;
      }
      char[] karakterer = new char[ordST.countTokens()];
      for(int i = 0; i < karakterer.length; i++){
        karakterer[i] = ordST.nextToken().trim().charAt(0);
      }
      String kode = ordAL.get(0);
      String navn = ordAL.get(1);
      int poeng = Integer.parseInt(ordAL.get(2));
      
      resultater.add(new Resultat(kode, navn, poeng, karakterer));
      linje = les.readLine();
    }
    les.close();
    
    for(Resultat resultat : resultater){
      System.out.println(resultat);
    }

//DEL 2
    FileOutputStream ut = new FileOutputStream("datafil.ser");
    ObjectOutputStream sendRes = new ObjectOutputStream(ut);
    for(Resultat resultat : resultater){
      sendRes.writeObject(resultat);
    }
    sendRes.close();
    
//DEL 3
    ArrayList<Resultat> resultater2 = new ArrayList<Resultat>();
    
    FileInputStream inn = new FileInputStream("datafil.ser");
    ObjectInputStream lesRes = new ObjectInputStream(inn);
    
    try{
      Resultat res = (Resultat) lesRes.readObject();
      while(res != null){
        resultater2.add(res);
        res = (Resultat) lesRes.readObject();
      }
    } catch(Exception e){}  
//DEL 4
  System.out.println("\n DEL 4:");
    for(Resultat resultat : resultater2){
      System.out.println(resultat);
    }
  } 
}
