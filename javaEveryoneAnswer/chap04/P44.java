package chap04;
import tg.*;

public class P44 {       
    public static void main(String[] args){
        double s = 100;
        int r = 5;
        double th = 360.0/r;
        TurtleFrame f =  new TurtleFrame();  
        Turtle m = new Turtle(); 
        f.add(m); 
        for(int i = 0; i < r; i++){
            m.fd((int)(2 * s * Math.cos(Math.toRadians(th))));
            m.rt(180 - th);
            m.fd(s);
            m.rt(2 * th);
            m.fd(s);
            m.rt(180);
        }
    }
}
