package chap09;
import chap05.HTurtle;
import tg.*;

public interface Drawable
{
    void draw(double x, double y);
}

class DrawHouse extends HTurtle implements Drawable{
    double size = 10;
    public void draw(double x, double y) {
        up(); moveTo(x, y, 0); down();
        house(size);
        size+= 10;
    }
}
class DrawStar extends Turtle  implements Drawable{
    double size = 10;
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
