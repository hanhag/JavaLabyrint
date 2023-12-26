import java.util.ArrayList;
class Aapning extends HvitRute{

    public Aapning(Labyrint labyrint, int rad, int kol){
        super(labyrint, rad,kol);
    }

    public char tilTegn(){
        return '5';
    }

    public void gaa(ArrayList<Tuppel> veiArg) { //dersom det er Aapning vil legge til i utveier
        vei = new ArrayList<>(veiArg);
        vei.add(new Tuppel(x,y));
        labyrint.leggTilUtvei(vei);
        //i maal!
       /*  System.out.println("Fant en aapning i Aapning!" + x + " " + y ); */
        
      }
}
