/*TestKlientLes.java*/
/*Testklient for innlesing av serialisert fil fra Tribune */

import java.io.*;
import java.util.*;

class TestKlientLes{
  public static void main(String[] args) throws IOException{

    FileInputStream fil = new FileInputStream("tribune.ser");
    ObjectInputStream input = new ObjectInputStream(fil);
    Tribune[] arena = new Tribune[4];

    try{
      for(int i = 0; i < arena.length; i++) {
        arena[i] = (Tribune) input.readObject();
      }
    }
    catch(ClassNotFoundException cnfe){
      System.out.println("FUUUU! \n" + cnfe); 
    }
    finally{
      input.close();
      fil.close();
    }
    
    for(Tribune tribune : arena){
      System.out.println(tribune);
    }   
  }
}
