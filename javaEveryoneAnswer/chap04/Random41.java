package chap04;
import tg.*;

public class Random41 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        for(int i = 0;i < 1000;i++){ 
            m.fd(10);
//          m.rt(360 * Math.random());
          m.rt(360 * Math.random() - 180);   // これで， -180 -- 180 になる。
        }
    }
}

