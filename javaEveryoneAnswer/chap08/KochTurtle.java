package chap08;
import tg.*;

public class KochTurtle extends Turtle {
    public static void main(String[] args){
        KochTurtle m = new KochTurtle();
        TurtleFrame f = new TurtleFrame(400,400);
        f.add(m);
        m.up(); m.moveTo(50,100, 90); m.down();     
        m.koch(300, 6); 
        m.up(); m.moveTo(75,150, 90); m.down();
        m.kochIsland(250, 5);
    }

    void koch(double length, int n){
        if(n==0) fd(length);
        else{
            koch(length/3, n-1);
            lt(60);
            koch(length/3, n-1);
            rt(120);
            koch(length/3, n-1);
            lt(60);
            koch(length/3, n-1);
        }
    }
    
    void kochIsland(double length, int n){
        koch(length, n); rt(120);
        koch(length, n); rt(120);
        koch(length, n); rt(120);
    }
}
