package chap12;
import tg.*;
import chap05.HTurtle;

public class Interrupt {
    public static void main(String[] args)  throws InterruptedException{
        TurtleFrame f = new TurtleFrame();
        HTurtle m = new HTurtle();
        f.add(m);
        Thread t = new Thread(()->{
            m.polygon(10, 50);
            m.polygon(5, 50);
        });
        t.start();
        f.getMousePosition();
        t.interrupt();
    }

}
