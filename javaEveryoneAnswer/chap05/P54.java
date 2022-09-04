package chap05;
import tg.*;

public class P54{    
    public static void main(String[] args){
        int n = 10;
        TurtleFrame f = new TurtleFrame(800,400);
        PolygonTurtle p = new PolygonTurtle();
        f.add(p);
        p.rt(90);
        for(int i = 1; i < n; i++){
            p.draw();
            p.fd(100);
        }
    }
}
