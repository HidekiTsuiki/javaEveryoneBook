package chap05;
import tg.TurtleFrame;

public class P521 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        MyTurtle m = new MyTurtle();
        f.add(m);
        m.house(50, 50, 150);
        m.house(40, 50, 350);
        m.houses(5, 30, 10, 150, 150);
        m.houses(5, 30, 10, 150, 250);
        m.houses(6, 24, 10, 150, 350);
    }
}
