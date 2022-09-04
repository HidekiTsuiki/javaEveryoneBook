package chap03;
import tg.*;

public class P32 {
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle(100,300,0);
        f.add(m);
        for(int i = 2; i <= 180; i+=2){
            m.fd(50);
            m.rt(i * 2);
        }
    }

}
