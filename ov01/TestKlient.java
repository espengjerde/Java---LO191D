/*TestKlient.java*/

class TestKlient{
  public static void main(String[] args){
    
    Restaurant rest = new Restaurant("rest", 2010, 10);
    
    System.out.println(rest.getNamn() + ", etabl." + rest.getEtablAar() + " (" + rest.getAlder() + " år)");
    
    rest.reserverBord("Espen");
    rest.reserverBord("Espen");
    rest.reserverBord("Espen");
    rest.reserverBord("Ole");
    rest.reserverBord("Ole");
    rest.reserverBord("Petter");

    System.out.println("Reserverte: " + rest.getAntReserverteBord() + "  Ledige: " + rest.getAntLedigeBord());
    System.out.println("Reservert på Espen:");
    for(int i = 0; i < rest.getReservert("Espen").length; i++){
      System.out.print(rest.getReservert("Espen")[i] + "  ");
    }
    
    int[] rydd = {0, 2, 3, 4};
    rest.ryddBord(rydd);
    System.out.println();

    System.out.println("Reserverte: " + rest.getAntReserverteBord() + "  Ledige: " + rest.getAntLedigeBord());
    
  } 
}
