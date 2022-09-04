package chap09;
import tg.*;

public class Random91 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new ColoredTurtle();   // ここだけ
        f.add(m);
        for(int i = 0;i < 1000;i++){ 
            m.fd(10);
//          m.rt(360 * Math.random());
          m.rt(360 * Math.random() - 180); 
        }
    }
}

