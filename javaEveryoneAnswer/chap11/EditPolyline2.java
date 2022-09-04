package chap11;
import tg.*;
import java.util.*;

public class EditPolyline2 {
    List<Point> polyline = new LinkedList<>();
    TurtleFrame f = new TurtleFrame();
    // ここから追加
    EditPolyline2(){
       f.addControlArea();
    }
    void start(){
        Turtle.setWithTurtleAll(false);
        while(true){
            show();
            Point p = f.getMousePosition();
            if(p.x < 10 && p.y < 10){
                int k = polyline.size();
                if(k > 0){
                    polyline.remove(k-1);
                }
            }else{ 
                polyline.add(p);
            }
            f.clear();
        }
    }
    // ここまで
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
        new EditPolyline2().start();
    }
    
}
