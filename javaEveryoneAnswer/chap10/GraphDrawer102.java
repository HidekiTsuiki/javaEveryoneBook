package chap10;
import tg.*;
import javafx.scene.paint.Color;

public class GraphDrawer102{
    double width = 400;            //画面の横幅 
    TurtleFrame f = new TurtleFrame();
    GTurtle m1 = new GTurtle();  
    GTurtle m2 = new GTurtle();  
    {           // 初期化ブロックを利用
        f.add(m1);  m1.speed(1); 
        f.add(m2);  m2.setColor(Color.RED);
        f.addMesh();
    } 
    void start(){                 //処理の本体
        m1.drawGraph(y->y*y);
        m1.drawLine(0, 0, 1, 1);
        m2.dynamics(y->y*y, 0.99, 10);
    }
    public static void main(String[] args){          
        GraphDrawer102 g = new GraphDrawer102();
        g.start();
    }                     
    class GTurtle extends Turtle{    //内部クラスGTurtle 
        void dMoveTo(double x, double y){
            moveTo(x * width, (1- y) * width);  
        }
        void drawGraph(UnitFun g){
            up();
            for(double x = 0; x < 1; x+= 1/width){
                dMoveTo(x, g.apply(x));
                down();
            }
        }
        void drawLine(double x, double y, double ex, double ey){
            up(); dMoveTo(x,y); down(); dMoveTo(ex, ey);
        }
        void dynamics(UnitFun g, double x, int count){
            up(); dMoveTo(x, 0); down();
            for(int i = 0; i < count; i++){
                double y = g.apply(x);
                dMoveTo(x, y);
                dMoveTo(y, y);
                x = y;
            }
        }
    }
    
 

}






