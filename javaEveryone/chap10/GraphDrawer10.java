package chap10;
import javafx.scene.paint.Color;
import tg.*;
public class GraphDrawer10{
    double width = 400;
    GTurtle m = new GTurtle(); 
    TurtleFrame f = new TurtleFrame();
    {
        f.add(m);
        f.addMesh();
    }
    void start(){
        m.drawGraph(x -> 3.5 * x * (1-x));
        m.setColor(Color.BLUE);
        m.drawGraph(x-> Math.sqrt(x));
    }
    public static void main(String[] args){
        new GraphDrawer10().start();
    }
    class GTurtle extends Turtle{
        void dMoveTo(double x, double y){
            moveTo(x *width, (1- y) * width);
        }
        void drawGraph(UnitFun g){
            up();
            for(double x = 0; x < 1; x+= 1/width){
                dMoveTo(x, g.apply(x));
                down();
            }
        }
    }
}

