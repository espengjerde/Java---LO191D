/*Konferansesenter.java*/

import java.util.*;

class Konferansesenter{
  private ArrayList<Rom> romma =  new ArrayList<Rom>();
  
  public boolean reserver(Kunde kunde, long fra, long til, int plasser){
    for(Rom rom : romma){
      if((rom.getPlass() >= plasser) && rom.reserver(fra, til, kunde)){
        return true;
      }
    }
    return false;
  }
  
  public Rom getRom(int romid){
    Rom svar = new Rom(-1,-1);
    for(Rom rom : romma){
      if(rom.getRomNr() == romid) svar = rom;
    }
    return svar;
  }
  
  public int nyttRom(int plasser){
    romma.add(new Rom(romma.size(), plasser));
    return romma.size() - 1;
  }
  
  public String toString(){
    String tekst = " Oversikt over konferansesenter: \n";
    for(Rom rom:romma){
      tekst += rom + "\n";
    }
    return tekst;
  }
}
