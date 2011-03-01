/*Valuta.java*/

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.*;

class Valuta{// extends JFrame{
  private String namn;
  private double kurs;
  private int enhet;
  
  public Valuta(String namn, double kurs, int enhet){
    this.namn = namn;
    this.kurs = kurs;
    this.enhet = enhet;
  }
  
  public String getNamn(){
    return namn;
  }
  public double getKurs(){
    return kurs;
  }
  public int getEnhet(){
    return enhet;
  }
  
  public void setKurs(double nyKurs){
    kurs = nyKurs;
  }
  
  public String toString(){
    return namn + ": " + kurs;
  } 
}
class Vindauge extends JFrame{
  private DefaultListModel fraValutaContent = new DefaultListModel();
  private JList fraValutaListe = new JList(fraValutaContent);
  private DefaultListModel tilValutaContent = new DefaultListModel();
  private JList tilValutaListe = new JList(tilValutaContent);
  
  private JLabel svar = new JLabel("Vel ein valuta");
  private JLabel infotekst = new JLabel("Superduper valutakalkulator 2011");
  
  public Vindauge(String tittel){
    setTitle(tittel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(infotekst, BorderLayout.NORTH);
    add(svar, BorderLayout.SOUTH);
    add(new Liste(fraValutaListe, fraValutaContent), BorderLayout.WEST);
    add(new Liste(tilValutaListe, tilValutaContent), BorderLayout.EAST);
    pack();
  }

  private class Liste extends JPanel{
//    Valuta[] valutaListe = {new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1), new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100), new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100), new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)};
    
    Valuta[] valutaListe = {new Valuta("Lav 1 valuta", 1, 1), new Valuta("Høg 1 valuta", 10, 1), new Valuta("Lav 100 valuta", 10, 100), new Valuta("Høg 100 valuta", 150, 100)};


    public Liste(JList jl, DefaultListModel dlm){
      dlm.addElement("Lag ny valuta");
      for(Valuta valuta : valutaListe){
        dlm.addElement(valuta);
      }
      jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      JScrollPane rullefelt = new JScrollPane(jl);
      add(rullefelt);
      jl.addListSelectionListener(new ListeLytter());

    }
  }
  private class ListeLytter implements ListSelectionListener{
    public void valueChanged(ListSelectionEvent hending){
      int vFra = fraValutaListe.getSelectedIndex();
      int vTil = tilValutaListe.getSelectedIndex();

/*Legg til ny valuta */      
      if(vFra == 0 || vTil == 0){
        String nyNamn = showInputDialog("Namn på ny valuta");
        double nyKurs = Double.parseDouble(showInputDialog("Kurs på ny valuta"));
        int nyEnhet = Integer.parseInt(showInputDialog("Eining for ny valuta"));
        
        Valuta nyValuta = new Valuta(nyNamn, nyKurs, nyEnhet);
        fraValutaContent.addElement(nyValuta);
        tilValutaContent.addElement(nyValuta);
      }
/* Rekne ut valutaforskjell */
      if(vFra > 0 && vTil > 0){
       Valuta fraValuta = (Valuta) fraValutaContent.get(vFra);
       Valuta tilValuta = (Valuta) tilValutaContent.get(vTil); 
       
       infotekst.setText("Du har valt " + fraValuta.getNamn() + " og " + tilValuta.getNamn() + ".");
       svar.setText("Oppgi antall eingar av " + fraValuta.getNamn());
       double antal = Double.parseDouble(showInputDialog("Antal einingar av " + fraValuta.getNamn() + ":"));
       
       double enhetsKursFra = fraValuta.getKurs() / fraValuta.getEnhet();
       double enhetsKursTil = tilValuta.getKurs() / tilValuta.getEnhet();
       
       double nyttAntal = (antal/enhetsKursTil)*enhetsKursFra;
       
       infotekst.setText("Klar for ny valutaomregning");
       svar.setText(antal + " " + fraValuta.getNamn() + " blir " + nyttAntal + " " + tilValuta.getNamn());
       fraValutaListe.clearSelection();
       tilValutaListe.clearSelection();     
      }
    }
  }
}
class ValutaProgram{
  public static void main(String[] args){
    Vindauge vindauge = new Vindauge("Valutakalkulator");
    vindauge.setVisible(true);
  }
}
