import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
public class Test{
public static void main(String[] args) throws Exception{

    String filnavn = null;
    if (args.length > 0) {
        filnavn = args[0];
    } else {
        System.out.println("FEIL! Riktig bruk av programmet: "
                           +"java Oblig6 <labyrintfil>");
        return;
    }
    File fil = new File(filnavn);
    Labyrint l = null;
    try {
        l = new Labyrint(fil);
        System.out.println(l.toString());
    } catch (FileNotFoundException e) {
        System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
        System.exit(1);
    }
   

    

    }
}
