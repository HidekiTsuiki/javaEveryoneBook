package chap10;
import tg.*;
import javafx.scene.paint.Color;

public class GraphDrawer103{
    double width = 400;            //画面の横幅 
    TurtleFrame f = new TurtleFrame();
    GTurtle m = new GTurtle();  
    {           // 初期化ブロックを利用
        f.add(m);
        f.addMesh();
    }
    
    void start(){                 //処理の本体
        Turtle.setWithTurtleAll(false);
        m.setColor(Color.BLUE);
        m.drawGraph(logistic(3.5));
        m.setColor(Color.BLACK);
        m.drawGraph(twice(logistic(3.5)));
        m.setColor(Color.ORANGE);
        m.drawGraph(repeat(logistic(3.5), 4));
    }
    public static void main(String[] args){          
        GraphDrawer103 g = new GraphDrawer103();
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






