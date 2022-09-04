package chap09;
import tg.*;
public class T92 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Drawable d;
        double r = Math.random();
        if(r < 0.3){ d = new DrawHouse(); f.add((Turtle) d);} 
        else if(r < 0.6){ d = new DrawStar(); f.add((Turtle) d);} 
        else d = new DrawText();
        d.draw(200,200);      
    }
}
