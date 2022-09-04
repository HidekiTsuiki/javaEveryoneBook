package chap09;
import tg.*;
import chap05.HTurtle;

public interface Drawable
{
    void draw(double x, double y);
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

class DrawHouse extends HTurtle implements Drawable{
    int size = 10;
    public void draw(double x, double y) {
        up(); moveTo(x, y, 0); down();
        house(size);
        size+= 10;
    }
}
class DrawStar extends Turtle  implements Drawable{
    int size = 10;
    public void draw(double x, double y) {
        up(); moveTo(x, y, 18); down();
        for(int i = 0; i < 5; i++){
            fd(size); rt(144);
        }
        size += 10;
    }
}
class DrawText  implements Drawable{
    public void draw(double x, double y) {
        for(int i = 0; i < x / 10; i++){
            System.out.print("*");
        }
        for(int i = 0; i < y / 10; i++){
            System.out.print("+");
        }
        System.out.println("");
    }
}
