package chap03;
import tg.*;

public class Mouse33 {         
    public static void main(String[] args){
        TurtleFrame f =  new TurtleFrame();  
        f.addControlArea();
        for(;;){
            Point p = f.getMousePosition();
            Turtle m = new Turtle(p.x,p.y,0);
            f.add(m);              
            for(;;){
                p = f.getMousePosition();
                if(p.x < 10 && p.y < 10) break;
                m.moveTo(p.x, p.y);
            }
            f.remove(m);
        }
    }
}
