/*Restaurant.java*/

class Restaurant{
  private String namn;
  private int etablert;
  private Bord bord;

  public Restaurant(String namn, int etablert, int antallBord){
    this.namn = namn;
    this.etablert = etablert;
    bord = new Bord(antallBord);
  }
  
  /* Gir året restauranten er etablert; */
  public int getEtablAar(){
    return etablert;
  }
  
  /* Returnere kor gammal restauranten er */
  public int getAlder(){
    int no = 2011; //java.util.GregorianCalendar.YEAR;
    return no - etablert;
  }
  
  public String getNamn(){
    return namn;
  }
  public void setNamn(String namn){
    this.namn = namn;
  }
  public int getAntLedigeBord(){
    return bord.getLedige();
  }
  public int getAntReserverteBord(){
    return bord.getReserverte();
  }
  
  /*Finner ut kva bord som er reservert på eit spesielt namn, returnerer liste med bordnr */
  public int[] getReservert(String namn){
    return bord.getReservasjoner(namn);
  }
  
  /*Tek imot ei liste med bord som skal ryddast, og ryddar borda (frigir)*/
  public void ryddBord(int[] bordnr){
    for(int i = 0; i < bordnr.length; i++){
      bord.ryddBord(i);
    }
  }
  
  /*Reservere bord for ein person; */
  
  public void reserverBord(String namn){
    bord.reserverBord(namn);
  }
  
  
}
