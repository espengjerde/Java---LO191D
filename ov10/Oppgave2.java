/*Oppgave2.java*/

/*
Lag et vindu som regner om mellom norske og svenske kroner. Brukeren skal skrive inn et beløp, trykke på knappen "Til norsk" eller "Til svensk" og få skrevet ut beløpet i den andre valutaen. 

Lag brukergrensesnittet slik at det kommer en feilmelding dersom det som skrives inn ikke kan tolkes som et tall (NumberFormatException).
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ValutaGUI extends JFrame{
  private JButton nokKnapp = new JButton("til NOK");
  private JButton sekKnapp = new JButton("til SEK");
  private JTextField innVerdi = new JTextField(10);
  private JLabel utVerdi = new JLabel("fremmed valuta kjem her");
  private static double KURS = 0.89;
  
  public ValutaGUI(){
    setTitle("SEK to NOK valuta");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    LayoutManager layout = new FlowLayout();
    setLayout(layout);
    
    add(innVerdi);
    add(nokKnapp);
    add(sekKnapp);
    add(utVerdi);
    
    pack();
    
    Lytter lytter = new Lytter();
    nokKnapp.addActionListener(lytter);
    sekKnapp.addActionListener(lytter);
  }
  private class Lytter implements ActionListener{
    public void actionPerformed(ActionEvent hending){
      JButton valg = (JButton) hending.getSource();
      try{
        double valuta = Double.parseDouble(innVerdi.getText());
        if(valg == nokKnapp){
          valuta = (valuta*KURS);
          String svar = "" + valuta;
          utVerdi.setText(svar);
        }
        else{
          valuta = (valuta/KURS);
          String svar = "" + valuta;
          utVerdi.setText(svar);
        }
       } catch(NumberFormatException nfe){
      //  javax.swing.JOptionPane.showMessageDialog(null, "Du må skrive inn tall!");
        utVerdi.setText("DU MÅ SKRIVE INN TALL!");
      }
    } 
  }
}
class Oppgave2{
  public static void main(String[] args){
    ValutaGUI vgui = new ValutaGUI();
    vgui.setVisible(true);
  }
}

