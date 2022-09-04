package chap04;
import tg.Turtle;
import tg.TurtleFrame;

public class P43 {       
    public static void main(String[] args){
        TurtleFrame f =  new TurtleFrame();  
        Turtle m = new Turtle(); 
        f.add(m); 
        for(int i = 0; i < 12; i++){
            m.fd(Math.sqrt(3) * 100);
            m.rt(150);
            m.fd(100);
            m.rt(60);
            m.fd(100);
            m.rt(180);
        }
    }
}
