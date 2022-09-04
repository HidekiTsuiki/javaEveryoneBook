package chap03;
import tg.*;
public class T32 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        int i;
        for(i = 1; i <= 10; i++){
            m.fd(i * 10);
            m.rt(72);
        }
    }  
}
