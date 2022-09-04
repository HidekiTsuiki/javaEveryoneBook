package chap09;
import chap05.HTurtle;
import tg.*;
import javafx.scene.paint.Color;

public class ColoredTurtle extends HTurtle{

    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        ColoredTurtle m = new ColoredTurtle();
        f.add(m);
        m.polygon(360, 1);
        System.out.println(m);
    }
    @Override
    public void fd(double n){
        double angle = getAngle();
        setColor(Color.hsb(angle,  1.0,  1.0));
        super.fd(n);
    }    
}




