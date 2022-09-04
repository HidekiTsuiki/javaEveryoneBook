package chap03;
import tg.*;
public class T36 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        for(int i = 0; i < 18; i++){
            m.fd(50);
            if(i % 3 == 0) m.lt(120);
            else m.rt(30);
        }
    }	
}
