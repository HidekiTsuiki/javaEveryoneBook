package chap12;
import chap05.HTurtle;

import java.util.stream.*;
import javafx.scene.paint.Color;
import tg.*;

public class StreamTurtle{
    public static void main(String[] args) throws InterruptedException{
        new StreamTurtle().start();
    }
    public void start() throws InterruptedException{  
        TurtleFrame f = new TurtleFrame();
        IntStream.range(3,20)
           .mapToObj(n->{
               FPTurtle m = new FPTurtle(n, 100, n*30, 90); 
               f.add(m); 
               return m;
               }).parallel()
           .map(m->{m.draw(10); return m;})
           .map(m->{m.draw(20); return m;})
           .map(m->{m.draw(30); return m;})
           .forEach(m->{m.setTColor(Color.RED);}); 
    }
    class FPTurtle extends HTurtle{  // Fixed Polygon Turtle 
        private int n;
        FPTurtle (int n, double x, double y, double a){
            super(x, y, a);
            this.n=n;
        }
        void draw(double len){
            double s  = len * Math.sin(Math.PI/n) * 2; 
            polygon(n, s); 
            fd(len * 2);
        }     
    }
}
