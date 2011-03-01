/*Medlemsarkiv.java*/
/*
  
  Medlemsarkiv
  -------------------------
  - ArrayList<BonusMedlem>
  -------------------------
  +nyMedlem()
  +finnPoeng();
  +registerPoeng();
  +sjekkMedlemmer();
  -------------------------
  */import java.util.*;
class Medlemsarkiv{
  private ArrayList<BonusMedlem> medlemmer = new ArrayList<BonusMedlem>();
  private final int SOLVMEDLEM = 50000 -1;
  private final int GULLMEDLEM = 75000 -1;

  private int finnLedignr(){
    Random random = new Random(medlemmer.size());
    int medlnr = random.nextInt(); 
    for(BonusMedlem medlem : medlemmer){
      if(medlnr == medlem.getMedlnr()){ medlnr = random.nextInt();}//Math.abs(random.nextInt());  }
    }
    return medlnr;//*-1;
  }
  
  public int nyMedlem(Personalia pers, Dato innmeldt){
    int medlnr = finnLedignr();
    System.out.println(medlnr);
    medlemmer.add(new BasicMedlem(Math.abs(medlnr), pers, innmeldt));
    return medlnr;
  }
  
  public boolean registrerPoeng(int medlnr, int poeng){
    for(BonusMedlem medlem : medlemmer){
      if(medlnr == medlem.getMedlnr()){
        medlem.registrerPoeng(poeng);
        return true;
      }
    }
    return false;
  }

  public int getPoeng(int medlnr){
    for(BonusMedlem medlem : medlemmer){
      if(medlem.getMedlnr() == medlnr) return medlem.getPoeng();
    }
    return -1;
  }
  
  public void sjekkMedlemmer(Dato idag){
    for(BonusMedlem medlem : medlemmer){
      if(medlem instanceof BasicMedlem){
        if(medlem.finnKvalPoeng(idag) > GULLMEDLEM){
          medlemmer.set(medlemmer.indexOf(medlem), new GullMedlem(medlem.getMedlnr(), medlem.getPers(), medlem.getInnmeldtDato(), medlem.getPoeng()));
        }
        else if(medlem.finnKvalPoeng(idag) > SOLVMEDLEM){
          medlemmer.set(medlemmer.indexOf(medlem), new SoelvMedlem(medlem.getMedlnr(), medlem.getPers(), medlem.getInnmeldtDato(), medlem.getPoeng()));
        }
      }
      else if(medlem instanceof SoelvMedlem && medlem.finnKvalPoeng(idag) > GULLMEDLEM){
        medlemmer.set(medlemmer.indexOf(medlem), new GullMedlem(medlem.getMedlnr(), medlem.getPers(), medlem.getInnmeldtDato(), medlem.getPoeng()));
      }
    }
  }
  
//ekstrametoder
  public int getMedlnr(Personalia person){
    for(BonusMedlem medlem : medlemmer){
      if(medlem.getPers().equals(person)) return medlem.getMedlnr();
    }
    return -1;
  }


  public String toString(){
    String tekst = "Medlemmer i arkivet:\n";
    for(BonusMedlem medlem : medlemmer){
      tekst += medlem + "\n";
    }
    return tekst + "\n I alt " + medlemmer.size() + " medlemmer.";
  }
}

/* TESTKILENT for Medlemsarkiv */

class TestMedlemsakiv{
  public static void main(String[] args) throws Exception{
   Medlemsarkiv arkiv = new Medlemsarkiv();
   
    Personalia ole = new Personalia("Olsen", "Ole", "ole.olsen@dot.com", "ole");
    Personalia tove = new Personalia("Hansen", "Tove", "tove.hansen@dot.com", "tove");
    Personalia tor = new Personalia("Sandbakken", "Tor Christian", "tc.sandbakken@dot.com", "tor");
    Personalia gunhild = new Personalia("Lundberg", "Gunhild Marie", "gm.lundberg@dot.com", "gunhild");
    Personalia jorn = new Personalia("Krutå", "Jørn Erling", "je.krutaa@dot.com", "joern");
    Dato dato = new Dato("10022008");
    Dato dato1 = new Dato("10122008");
    Dato dato2 = new Dato("11022009");
    
    int mnrOle = arkiv.nyMedlem(ole,dato);
    int mnrTove = arkiv.nyMedlem(tove,dato);
    int mnrTor = arkiv.nyMedlem(tor,dato);
    int mnrGun = arkiv.nyMedlem(gunhild,dato);
    int mnrJorn = arkiv.nyMedlem(jorn,dato);
    
    System.out.println(arkiv);
    
    System.out.println("\nLegger til poeng på medlemmane");
    arkiv.registrerPoeng(mnrOle, 5000);
    arkiv.registrerPoeng(mnrTove, 20000);
    arkiv.registrerPoeng(mnrTor, 56000);
    arkiv.registrerPoeng(mnrGun, 21000);
    arkiv.registrerPoeng(mnrJorn, 76000);
    
    
    System.out.println(arkiv);
    System.out.println("\n Kjører sjekkMedlemmer()\n");
    arkiv.sjekkMedlemmer(dato1);
    System.out.println(arkiv);
    
    System.out.println("\n Legger til litt poeng... \n");
    
    arkiv.registrerPoeng(mnrTove, 20000);
    arkiv.registrerPoeng(mnrOle, 17000);
    arkiv.registrerPoeng(mnrGun, 34000);
    
    System.out.println("\n Kjører sjekkMedlemmer() (dager > 365)\n");
    arkiv.sjekkMedlemmer(dato2);
    System.out.println(arkiv);
    
    System.out.println("\n Kjører sjekkMedlemmer() (dager < 365)\n");
    arkiv.sjekkMedlemmer(dato1);
    System.out.println(arkiv);
    
    
  }
}
