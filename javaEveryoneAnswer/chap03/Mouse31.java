package chap03;
import tg.*;

public class Mouse31 {         
    public static void main(String[] args){
        TurtleFrame f =  new TurtleFrame();  
        Point p = f.getMousePosition();
        Turtle m = new Turtle(p.x,p.y,0);
        f.add(m);              
        for(int i = 0; i < 10; i++){
            p = f.getMousePosition();
            m.moveTo(p.x, p.y);
        }
        f.remove(m);
        System.out.println("Program finished.");
    }
}
