import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Hovedprogram {


    public static void main (String[] args){
        JFrame vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Labyrint l = null;
        
        
        LabyrintBrett labGUI = new LabyrintBrett();
        labGUI.initGUI();
        vindu.add(labGUI);



        vindu.pack();
        vindu.setVisible(true);

    }
}