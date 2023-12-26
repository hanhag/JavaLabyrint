public class Tuppel { //tuppel for ruteposisjon

    int x;
    int y;
  
    public Tuppel(int x, int y) {
      this.x = x;
      this.y = y;
    }
  
    
    public boolean equals(Tuppel tpl) {
        if (x == tpl.x && y == tpl.y){
            return true;
        }else{
            return false;}
        
    }
  
    @Override
    public String toString() {
      return "(" + x + "," + y + ")";
    }
  }