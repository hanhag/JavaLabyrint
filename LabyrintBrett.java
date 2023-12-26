import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.Scanner;

public class LabyrintBrett extends JPanel{
    
  JButton sluttknapp;
  JLabel statustekst;
  JButton filvelg;
  Labyrint labyrint;
  Rute[][] ruter;
  Rutenett rutenettet;
  
 

  // public LabyrintBrett() {
  //     // rutenettet = new Rutenett(this);
  // }

  void initGUI()  {
    /* rutenettet.initGUI();
    add(rutenettet); */

    statustekst = new JLabel("Labyrintfil");
    add(statustekst);

    //knapp for aa velge fil
    filvelg = new JButton("velg fil");
    class filvelger implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent e) {
       //filvelger
       JFileChooser filvelger = new JFileChooser(".");
       int resultat = filvelger.showOpenDialog(null);
       if (resultat != JFileChooser.APPROVE_OPTION) System.exit(1);
       File fil = filvelger.getSelectedFile();

       //labyrint hentet fra 6
       Labyrint l = null;
       try {
           l = new Labyrint(fil);
       } catch (FileNotFoundException e1) {
           System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", fil.getName());
           System.exit(1);
       }

       Rutenett nytt_rutenettet = new Rutenett(l);

       remove(rutenettet);
       nytt_rutenettet.initGUI(); 
       add(nytt_rutenettet);
       rutenettet = nytt_rutenettet;

       // TODO: Refresh vinduet automatisk
      }
    }
    
    filvelg.addActionListener(new filvelger());
    add(filvelg);

    rutenettet = new Rutenett();
    rutenettet.initGUI();
    add(rutenettet);

    
    
    //exitknappen
    sluttknapp = new JButton("EXIT");
    class Stoppebehandler implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent e) {
          System.exit(0);
      }
    }
    
    sluttknapp.addActionListener(new Stoppebehandler());
    add(sluttknapp);

    
  }
    

   

    
}
