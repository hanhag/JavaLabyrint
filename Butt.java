import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;

public class Butt extends JButton {
   
    int x;
    int y;
    Rute rute;
    // Labyrint labyrint;
    Rutenett rnett;
    

    Butt(/* Labyrint labyrint, int x, int y,  */Rute r, Rutenett rnett)    {
        super();
        this.rute = r;
        this.rnett = rnett;
    }

    void initGUI ()  {
        if (rute == null) {
            setBackground(Color.green);
        }
        else if (rute.tilTegn() == '.' || rute.tilTegn() == '5') {
            setBackground(Color.white);
        } else {
            setBackground(Color.red);
        }
        setFont(new Font("Monospaced", Font.BOLD, 50));
        setPreferredSize(new DimensionUIResource(20, 20));
        setText(" ");

        Butt thisButt = this;
        class KnappVelger implements ActionListener {
            @Override
            /* public void actionPerformed(ActionEvent e)  {
                ArrayList<ArrayList<Tuppel>> utveier = labyrint.finnUtveiFra(x, y);
                rnett.hentRuteKord(utveier.get(0));
            } */
            public void actionPerformed(ActionEvent e)  {
                rnett.clear();
                ArrayList<ArrayList<Tuppel>> utveier = rute.labyrint.finnUtveiFra(rute.x, rute.y);
                
                if (utveier.isEmpty()) {
                    return;
                }


                ArrayList<Tuppel> kortestUtvei = utveier.get(0);
                for (ArrayList<Tuppel> utvei : utveier) {
                    if(utvei.size() < kortestUtvei.size()) {
                        kortestUtvei = utvei;
                    }
                }
                rnett.visUtvei(kortestUtvei);
            }
        }
        addActionListener(new KnappVelger());
    }
    void setText () {
        System.out.println("Kord: " + getLocation());
    }

    public void visVei() {
        setBackground(Color.green);
        // updateUI();   
    }
}
