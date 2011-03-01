/*Oppgave1.java */

/*
Lag et vindu med en tekst (et objekt av klassen JLabel, innholdet i teksten kan være hva som helst) og fire trykknapper, en for hver av skrifttypene SansSerif, Serif, Monospaced og Dialog. Teksten skal skifte skrifttype etter som brukeren trykker på knappene. Forsøk gjerne å gjøre programmet så generelt som mulig mht. antall og type skrifttyper.

*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class FontGUI extends JFrame{
  private JButton sansKnapp = new JButton("Sans Serif");
  private JButton serifKnapp = new JButton("Serif");
  private JButton monoKnapp = new JButton("Monospaced");
  private JButton dialogKnapp = new JButton("Dialog");
  private JLabel utTekst = new JLabel("Venter på tekst");
  private JTextField innTekst = new JTextField(15);
  
  public FontGUI(){
    setTitle("Øving 10, Oppgave 1");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    LayoutManager layout = new FlowLayout();
    setLayout(layout);
    
    add(innTekst);
    add(sansKnapp);
    add(serifKnapp);
    add(monoKnapp);
    add(dialogKnapp);
    add(utTekst);
    
    pack();
    
    Lytter lytter = new Lytter();
    sansKnapp.addActionListener(lytter);
    serifKnapp.addActionListener(lytter);
    monoKnapp.addActionListener(lytter);
    dialogKnapp.addActionListener(lytter);
    
  }
    private class Lytter implements ActionListener{
      public void actionPerformed(ActionEvent hending){
      
      JButton valg = (JButton) hending.getSource();
      String tekst = innTekst.getText();
      if(valg == sansKnapp){
        System.out.println("sans");
        utTekst.setFont(new Font("SansSerif",Font.PLAIN, 12));
      } else if(valg == serifKnapp){
        System.out.println("serif");
        utTekst.setFont(new Font("Serif",Font.PLAIN, 12));
      } else if(valg == monoKnapp){
        System.out.println("mono");
        utTekst.setFont(new Font("Monospaced",Font.PLAIN, 12));
      } else if(valg == dialogKnapp){
        System.out.println("dialog");
        utTekst.setFont(new Font("Dialog",Font.PLAIN, 12));
      }
      
      utTekst.setText(tekst);
    }
  }  
}
class Oppgave1{
  public static void main(String[] args){
    FontGUI gui = new FontGUI();
    gui.setVisible(true);
  }
}
