package graph;
import tg.*;
import javafx.scene.paint.Color;

public class GraphDrawer53{
    double a = 2.0;              // fun のパラメータ
    double fun (double x){     //描画する関数
        return a * x * (1-x);
    }                                      
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
        for(;;){
            Point p = f.getMousePosition();  
            f.clear();
            a = (width-p.y)*4/width;   
            double x = p.x/ width;
            m1.drawGraph();  
            m1.drawLine(0, 0, 1, 1);
            m2.dynamics(x,  100);
        }
    }
    public static void main(String[] args){          
        new GraphDrawer53().start();
    }                     
    class GTurtle extends Turtle{    //内部クラスGTurtle 
        void dMoveTo(double x, double y){
            moveTo(x * width, (1- y) * width);  
        }
        void drawGraph(){
            up(); dMoveTo(0, fun(0)); down();
            for(double x = 0; x < 1; x+= 1/width){
                dMoveTo(x, fun(x));  
            }
        }
        void drawLine(double x, double y, double ex, double ey){
            up(); dMoveTo(x,y); down(); dMoveTo(ex, ey);
        }
        void dynamics(double x, int count){
            up(); dMoveTo(x, 0); down();
            for(int i = 0; i < count; i++){
                double y = fun(x);
                dMoveTo(x, y);
                dMoveTo(y, y);
                x = y;
            }
        }
    }     
}






