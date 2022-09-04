package chap02;
import tg.*;

public class Mouse21 {         
    public static void main(String[] args){
        TurtleFrame f =  new TurtleFrame();  
        Turtle m = new Turtle();
        f.add(m);
        Point p = f.getMousePosition();
        m.up();
        m.moveTo(p.x, p.y, 0);
        m.down();
        m.rt(162);
        m.fd(100);
        m.rt(144);
        m.fd(100);
        m.rt(144);
        m.fd(100);
        m.rt(144);
        m.fd(100);
        m.rt(144);
        m.fd(100);
        m.rt(144);
    }
}   
