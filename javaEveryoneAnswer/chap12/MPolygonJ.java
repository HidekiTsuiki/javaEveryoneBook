package chap12;
import tg.*;
import chap05.HTurtle;

public class MPolygonJ{
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        HTurtle m1 = new HTurtle(200,200,0);  f.add(m1);
        HTurtle m2 = new HTurtle(100,200,0);  f.add(m2);
        Thread t1 = new Thread(()->{m1.polygon(10,50);});
        t1.start();
        Thread t2 = new Thread(()->{m2.polygon(5, 50);});
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){}
        f.clear(); 
        System.out.println("Main メソッドは終了する。");  
    }
}
