import java.util.ArrayList;
class HvitRute extends Rute {

    public HvitRute(Labyrint labyrint, int rad, int kol){
        super(labyrint, rad,kol);
    }
    
    public char tilTegn(){
        return '.';
    }

    public void gaa(ArrayList<Tuppel> veiArg){

        vei = new ArrayList<Tuppel>(veiArg);
        vei.add(new Tuppel(x,y));
        Tuppel forrige;
        if(veiArg.size()==0){ //forste er tom, da er forrige den ruta vi er i
            forrige = vei.get(vei.size()-1);
        }else{
            forrige = veiArg.get(veiArg.size()-1);
        }
       
        try{ //sjekker naboer, dersom nabo er forrige saa skal vi ikke kalle gaa paa den
            if(!(nord.equals(forrige))){ 
                /* System.out.println("nord" + labyrint.hentRuteKord(nord)); */
             labyrint.hentRuteKord(nord).gaa(vei);   
            }
            //try catch fordi det ikke er sikkert naboene finnes
        }catch (Exception e) {}
        try{
            if(!(ost.equals(forrige))){
               /* System.out.println("ost" + labyrint.hentRuteKord(ost)); */
                labyrint.hentRuteKord(ost).gaa(vei);   
               }
            
        }catch  (Exception e) {}
        try{
            if(!(vest.equals(forrige))){
                /* System.out.println("vest" + labyrint.hentRuteKord(vest)); */
                labyrint.hentRuteKord(vest).gaa(vei);   
               }
        }catch (Exception e) {}
        try{
            if(!(sor.equals(forrige))){
                /* System.out.println("sor" + labyrint.hentRuteKord(sor)); */
                labyrint.hentRuteKord(sor).gaa(vei);   
               }
           
        }catch  (Exception e) {}

        
        /* System.out.println("gaar videre fra " + x + " " + y); */
        

        
    }
}
