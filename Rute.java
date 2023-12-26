import java.util.ArrayList;

abstract class Rute {
    Labyrint labyrint;
    Tuppel nord; 
    Tuppel sor; 
    Tuppel ost;
    Tuppel vest;
    ArrayList<Tuppel> vei;
    ArrayList<Tuppel> naboer;
    public int x;
    public int y;

    public Rute(Labyrint labyrint, int x, int y){
        this.labyrint = labyrint;
        this.x = x;
        this.y = y;
        nord = new Tuppel(x, y-1);
        sor = new Tuppel(x, y+1);
        ost = new Tuppel(x+1, y);
        vest = new Tuppel(x-1,y);
        

    }

   public abstract void gaa(ArrayList<Tuppel> veiArg);

   abstract char tilTegn();

   

   public void finnUtvei() {
    gaa(new ArrayList<Tuppel>());
  }
  @Override
   public String toString(){
       return "Koordinater -> " + x + " " + y ;
   }
   

   
}
