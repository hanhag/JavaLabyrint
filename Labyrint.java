import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException; 
public class Labyrint {
    
    public Rute[][] labyrint;
    public int hoyde;
    public int bredde;
    
    public ArrayList<ArrayList<Tuppel>> utveier = new ArrayList<ArrayList<Tuppel>>();
   

    public Rute hentRute(int x, int y){
        return labyrint[x][y];
    }

    public Rute hentRuteKord(Tuppel tpl){
        return labyrint[tpl.x][tpl.y];
    }

    public Rute[][] hentRutes(){
        return labyrint;
    }

    public Labyrint(File f) throws FileNotFoundException{
        labyrint = lesInn(f);
    }
    
    public Rute[][] lesInn(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);

        String linje = sc.nextLine();
        String[] str = linje.split(" ");
        int teller = 0;
        int antR = Integer.parseInt(str[0]);
        int antK = Integer.parseInt(str[1]);

        Rute[][] ruterArray = new Rute[antK][antR];
        

        /* Labyrint labyrint = new Labyrint(antK,antR); */

        while (sc.hasNextLine()){
            linje = sc.nextLine();
            for (int i = 0; i < linje.length(); i++){
                if (String.valueOf(linje.charAt(i)).equals(".")) { //dersom det er aapning 
                    if (i == 0 || teller == 0 || i == antK - 1 || teller == antR - 1) {
                        Aapning aapning = new Aapning(this, i, teller);
                        ruterArray[i][teller] = aapning;
                    } else {
                        HvitRute hvitRute = new HvitRute(this, i, teller);
                        ruterArray[i][teller] = hvitRute;
                    }
                } else {
                    SortRute sortRute = new SortRute(this, i, teller);
                    ruterArray[i][teller] = sortRute;
            }
            
        }
        teller++;
        }
        
        
        return ruterArray;
    }

    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int kol, int rad) {
        utveier.clear();
        labyrint[kol][rad].finnUtvei();
        return utveier;
      }

    public void leggTilUtvei(ArrayList<Tuppel> utvei) {
        utveier.add(utvei);
      }

    @Override
    public String toString() {
        String string = "";

        for (int y = 0; y < hoyde; y++) {
            for (int x = 0; x < bredde; x++) {
                string += Character.toString(labyrint[x][y].tilTegn());
            }
            string += "\n";
        }
        return string;
    }

   
  
}

