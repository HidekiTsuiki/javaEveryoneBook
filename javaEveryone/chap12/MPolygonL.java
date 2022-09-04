package chap12;
import chap05.HTurtle;
import tg.*;
public class MPolygonL{
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        HTurtle m1 = new HTurtle(200,200,0);  f.add(m1);
        HTurtle m2 = new HTurtle(100,200,0);  f.add(m2);
        new Thread(()->{m1.polygon(10,50);}).start();
        new Thread(()->{m2.polygon(5, 50);}).start();
        System.out.println("Main メソッドは終了する。");  
    }
}
