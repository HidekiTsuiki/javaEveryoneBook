package chap03;
import tg.*;
public class T31 {
    public static void main(String[] args){ 
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        int i;
        for(i = 0; i < 5; i++){
            m.fd(100);
            m.rt(360.0/5);  
        }
    } 
}
