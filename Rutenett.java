import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.ArrayList;

public class Rutenett extends JPanel {
    Labyrint l;
    int rutex = 12;
    int rutey = 12;

    int totalt;
    Butt blokker[][];
    

    Rutenett() {
        blokker = new Butt[rutex][rutey];

        for (int i = 0; i < rutex; i++) {
            for (int j = 0; j < rutey; j++) {
                blokker[i][j] = new Butt(null, this);
            }
        }
    }

    Rutenett (Labyrint b)  {
        l = b;
        rutex = b.labyrint.length;
        rutey = b.labyrint[0].length;

        totalt = rutex*rutey;
        blokker = new Butt[rutex][rutey];
        
        int k = 0;
        for (int i = 0; i < rutex; i++) {
            for (int j = 0; j < rutey; j++) {
                blokker[i][j] = new Butt(b.labyrint[i][j], this);
            }
        }
    }

    public void visUtvei(ArrayList<Tuppel> utvei) {
        System.out.println("Fant utvei:");
        for (Tuppel tuppel : utvei) {
            System.out.println("(" + tuppel.x + ", " + tuppel.y + ")");
            blokker[tuppel.x][tuppel.y].visVei();
        }
    }

    public void clear() {
        for (Butt[] butts : blokker) {
            for (Butt butt : butts) {
                butt.initGUI();
            }
        }
    }

    void initGUI()  {
        setLayout(new GridLayout(rutex,rutey));

        for (int i = 0; i < rutex; i++) {
            for (int j = 0; j < rutey; j++) {
                blokker[i][j].initGUI();
                add(blokker[i][j]);
            }
        }
    }
}
