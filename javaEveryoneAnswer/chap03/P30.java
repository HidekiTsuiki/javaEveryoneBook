package chap03;
import tg.*;

public class P30 {       
    public static void main(String[] args){
        TurtleFrame f;              
        f =  new TurtleFrame();  
        Turtle m = new Turtle(); 
        f.add(m); 
        for(int i = 0; i < 5; i++){
            m.fd(100);                
            m.rt(144);                 
        }           
    }
}
