/*TestKlient.java*/
/* Testklient for Tribune.java og Billetter.java */
import java.util.*;
import java.io.*;
class TestKlient{
  public static void main(String[] args){
    Tribune[] arena = {new Staa("HeimeStå",50,100), new Staa("BorteStå",10,100), new Sitte("Familie",100,10,10), new VIP("VIP",1000,5,5)};
  
    
    ArrayList<Billett> b1 = arena[0].kjøpBilletter(35);
    String[] navn = {"Per","Pål","Espen Askeladden"};
    ArrayList<Billett> b2 = arena[0].kjøpBilletter(navn);
    
    ArrayList<Billett> b3 = arena[1].kjøpBilletter(5);
    String[] navn1 = {"Donald","Ole","Dole","Doffen"};
    ArrayList<Billett> b4 = arena[1].kjøpBilletter(navn1);
    
    ArrayList<Billett> b5 = arena[2].kjøpBilletter(10);
    String[] navn2 = {"Gudbrand i Lia","Snøkvit","Rosenrød","Mestertyven","Kari Trestakk"};
    ArrayList<Billett> b6 = arena[2].kjøpBilletter(navn2);
    
    String[] navn31 = {"Asbjørnsen","Moe"};
    ArrayList<Billett> b7 = arena[3].kjøpBilletter(navn31);
    String[] navn32 = {"Onkel Skrue","Fetter Anton","Dolly Duck"};
    ArrayList<Billett> b8 = arena[3].kjøpBilletter(navn32);

    for(Tribune tribune : arena){
      System.out.println(tribune);
    }
    System.out.println("Billetter:");
        for(Billett b : b1){
      System.out.println(b);
    }
    System.out.println();
    for(Billett b : b2){
      System.out.println(b);
    }
    System.out.println();
    for(Billett b : b3){
      System.out.println(b);
    }
    System.out.println();
    for(Billett b : b4){
      System.out.println(b);
    }
    System.out.println();
    for(Billett b : b5){
      System.out.println(b);
    }
    System.out.println();
    for(Billett b : b6){
      System.out.println(b);
    }
    System.out.println();
    for(Billett b : b7){
      System.out.println(b);
    }
    System.out.println();
    for(Billett b : b8){
      System.out.println(b);
    }
 
    
    System.out.println();
    Arrays.sort(arena);
    for(Tribune tribune : arena){
      System.out.println(tribune);
    }
  }
}
/*
  try{
    FileOutputStream fil = new FileOutputStream("tribune.ser");
    ObjectOutputStream ut = new ObjectOutputStream(fil);
    
    for(Tribune tribune : arena){
      ut.writeObject(tribune);
    }
    ut.close();
    fil.close();
  }
  catch(IOException ioe){  }
  
  }
}*/
