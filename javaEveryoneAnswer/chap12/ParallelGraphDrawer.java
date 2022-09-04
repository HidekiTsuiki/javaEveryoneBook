package chap12;
import tg.*;
import javafx.scene.paint.Color;

public class ParallelGraphDrawer{
    int numturtle = 20;   // 並行実行するタートルの個数
    double a = 3.4;             
    double fun (double x){     
        return a * x * (1-x);
    }                                      
    double width = 400;        
    TurtleFrame f = new TurtleFrame();
    GTurtle m = new GTurtle();  
    {         
        f.addMesh();
        f.add(m);
    }                
    void start(){           
        // グラフ描画などの準備
        Turtle.setWithTurtleAll(false);
        m.setWidth(1.0);  m.drawGraph();
        m.setWidth(0.2);m.drawLine(0, 0, 1, 1);
        f.remove(m);
        Turtle.setWithTurtleAll(true);

        // タートルの並列実行
        for(int i = 0; i < numturtle; i++){
            double x = ((double)i)/numturtle;
            new Thread(()->{
                GTurtle m1 = new GTurtle();
                f.add(m1);                    
                m1.dynamics(x,  100);
            }).start();
        }
    }
    public static void main(String[] args){          
        new ParallelGraphDrawer().start();
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
            setWidth(0.5);setColor(Color.RED);
            up(); dMoveTo(x, 0); down();
            for(int i = 0; i < count; i++){
                if(i == 50) setColor(Color.BLUE);
                double y = fun(x);
                dMoveTo(x, y);
                dMoveTo(y, y);
                x = y;
            }
            setColor(Color.BLACK);
        }
    }     
}






