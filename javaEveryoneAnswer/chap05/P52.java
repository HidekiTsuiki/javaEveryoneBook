package chap05;
import tg.TurtleFrame;

public class P52 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        MyTurtle m = new MyTurtle();
        f.add(m);
        m.up(); m.moveTo(200, 350, 0); m.down();
        m.houses(3, 40, 10);
        m.up(); m.moveTo(220, 250, 0); m.down();
        m.houses(3, 40, 10);
        m.up(); m.moveTo(100, 100, 0); m.down();
        m.pPolygon(10, 3, 15);
        m.up(); m.moveTo(100, 300, 0); m.down();
        m.flower(6, 10, 10);
        m.bk(50); m.rt(60); m.fd(20); m.bk(20);
        m.lt(120);m.fd(20);m.bk(20); m.rt(60);
    }
}
