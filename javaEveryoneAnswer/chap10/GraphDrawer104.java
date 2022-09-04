package chap10;
import tg.*;
import javafx.scene.paint.Color;

public class GraphDrawer104{
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
            double a = (width - p.y)*4/width;
            m1.drawGraph(logistic(a));  // logistic を使ってみた
            m1.drawLine(0, 0, 1, 1);
            m2.dynamics(logistic(a), p.x/width, 10);
            //          m.drawGraph(x->a*x*(1-x));
//          m.drawGraph(twice(x->a*x*(1-x)));
//          m.dynamics(twice(x->a*x*(1-x)), p.x/width, 100);
        }
    }
    public static void main(String[] args){          
        GraphDrawer104 g = new GraphDrawer104();
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
            setColor(Color.RED);
        }
    }    

    public static UnitFun logistic(double a){
        return x->a * x * (1-x); 
    }
    public static UnitFun compose(UnitFun f, UnitFun g){
        return x-> f.apply(g.apply(x));
    }
    public static UnitFun twice(UnitFun f){
        return compose(f, f);
    }
    /*  
     *  繰り返しによる repeat   
     */
    public static UnitFun repeat_iter(UnitFun f, int n){    
        UnitFun ff = x->x;  //恒等関数から始めて
        for(int i = 0; i < n; i++){
            ff = compose(f, ff);
        }
        return ff;
    }
    /*  
     *  再帰による repeat
     */
    public static UnitFun repeat(UnitFun f, int n){    
        if(n == 1) return f;
        else return compose(f, (repeat (f, n-1)));
    }

}






