package chap10;
import javafx.scene.paint.Color;
import tg.*;
public class GraphDrawer101{
    double width = 400;
    GTurtle m = new GTurtle(); 
    TurtleFrame f = new TurtleFrame();
    {
        f.add(m);
        f.addMesh();
    }
    void start(){
//        m.drawGraph(x -> 3.5 * x * (1-x));
        m.setColor(Color.BLUE);
//        m.drawGraph(x-> Math.sqrt(x));
        m.setColor(Color.GREEN);
        m.drawGraph(x-> x * x);
        m.setColor(Color.ORANGE);
        m.drawGraph(x-> Math.sin(Math.PI * x));
        m.setColor(Color.RED);
        m.drawGraph(x-> (1+ Math.sin(Math.PI * 2 * x))/2);
    }
    public static void main(String[] args){
        new GraphDrawer101() .start();
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

