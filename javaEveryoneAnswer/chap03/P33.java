package chap03;
import tg.*;

public class P33 {
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle(140,200,0);
        f.add(m);
        for(int i = 0; i < 270; i++){
            m.fd(i);
            m.rt(i);
        }
    }

}
