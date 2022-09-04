package chap11;
import tg.*;
import java.util.*;

public class EditPolyline {
    List<Point> polyline = new LinkedList<>();
    TurtleFrame f = new TurtleFrame();
    void start(){
        Turtle.setWithTurtleAll(false);
        while(true){
            show();
            Point p = f.getMousePosition();
            polyline.add(p);
            f.clear();
        }
    }
    void show(){
        Turtle m = new Turtle();
        f.add(m);
        m.up(); 
        for(Point p : polyline){
            m.moveTo(p.x, p.y);
            m.down();
        }
        f.remove(m);
    }
    
    public static void main(String[] args){
        new EditPolyline().start();
    }
    
}
