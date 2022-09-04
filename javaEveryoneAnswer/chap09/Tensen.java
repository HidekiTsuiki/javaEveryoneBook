package chap09;
import chap05.HTurtle;
import tg.*;

public class Tensen extends HTurtle{
    double psize = 10;

    @Override 
    public void fd(double s){
        int k;
        double len;
        for(k = 0, len = 0 ; len + psize <= s; k++, len+= psize){
            if(k % 2 == 0) down(); else  up();
            super.fd(psize);   
        }
        down();            
        super.fd(s - len); 
    }
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Tensen m = new Tensen();    
        f.add(m);
        m.fd(100);  
        m.rt(90);
        m.up(); m.fd(100); m.down(); 
        m.lt(90);
        m.polygon(5, 50);  
    }
}
