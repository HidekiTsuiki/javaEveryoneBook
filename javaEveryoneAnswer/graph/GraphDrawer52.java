package graph;
import tg.*;

public class GraphDrawer52{
    double a = 2.0;              // fun のパラメータ
    double fun (double x){     //描画する関数
        return a * x * (1-x);
    }                                      
    double width = 400;            //画面の横幅 
    TurtleFrame f = new TurtleFrame();
    GTurtle m = new GTurtle();  
    {           // 初期化ブロックを利用
        f.add(m);
        f.addMesh();
    }                
    void start(){                 //処理の本体
        for(;;){
            Point p = f.getMousePosition();  
            f.clear();
            a = (width-p.y)*4/width;   
            m.drawGraph();
        }
    }
    public static void main(String[] args){          
        new GraphDrawer52().start();
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
    }     
}
