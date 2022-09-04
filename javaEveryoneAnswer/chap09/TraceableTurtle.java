package chap09;
import chap05.HTurtle;
import tg.*;

public class TraceableTurtle extends HTurtle{
    //練習問題 (1)
    @Override
    public String toString(){
        return "(x=" +  getX() + ", y=" + getY() + ", angle=" + getAngle() + ")";
    }

    //練習問題 (２)
    @Override
    public void fd(double n){
        super.fd(n);
        System.out.println(this);
    }

    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        TraceableTurtle m = new TraceableTurtle();
        f.add(m);
        m.polygon(5, 100);
    }
}
