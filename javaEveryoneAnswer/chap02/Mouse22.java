package chap02;
import tg.*;

public class Mouse22 {         
    public static void main(String[] args){
        TurtleFrame f =  new TurtleFrame();  
        Point p = f.getMousePosition();
        Turtle m = new Turtle(p.x, p.y, 0);
        f.add(m);              
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        p = f.getMousePosition();
        m.moveTo(p.x, p.y);
        f.remove(m);
    }
}   
