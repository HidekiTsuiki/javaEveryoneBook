package chap12;
import chap05.HTurtle;
import tg.*;
public class MPolygon extends HTurtle implements Runnable{
    private int n;
    private double s;
    MPolygon(int n, double s, double x, double y, double a){
        super(x, y, a);
        this.n = n;    this.s = s;
    }
    public void run(){
        polygon(n,s); 
    }
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        MPolygon m1 = new MPolygon(10, 50, 200, 200, 0);  f.add(m1);
        MPolygon m2 = new MPolygon( 5, 50, 100, 200, 0);  f.add(m2); 
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        t1.start();
        t2.start();
        System.out.println("Main メソッドは終了する。");  
    }
}
