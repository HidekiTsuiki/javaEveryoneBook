package chap03;
import tg.*;
public class T34 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        int i = 1;
        while(m.getY() > 0){
            m.fd(i * 10);
            m.rt(72);
            i++;
        }
    }	
}
