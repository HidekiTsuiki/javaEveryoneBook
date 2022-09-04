package chap08;
import javafx.scene.paint.Color;
import tg.*;

public class HilbertTurtle extends Turtle{
    boolean rect = false;  // true にすると，赤い四角も描きます。 
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame();
        HilbertTurtle m = new HilbertTurtle();
        f.add(m);
        m.up();m.moveTo(50, 350, 90); m.down();
        m.hilbert(300, 1, 5);
    }

    void hilbert(double len , int which, int n){
        if(n > 0){
            double fdlen = len /Math.pow(2,n);  // この計算がポイント 
            lt(which*90);
            hilbert(len /2,-which, n-1);
            fd(fdlen);
            rt(which*90);
            hilbert(len /2,which, n-1);
            fd(fdlen);
            hilbert(len /2,which, n-1);
            rt(which*90);
            fd(fdlen);
            hilbert(len /2,-which, n-1);
            lt(which*90);
        }else{   // 四角形を描かないなら，この else は不要。
            if(rect){
                setColor(Color.RED);
                up(); fd(len /2);lt(90);down();fd(len /2);lt(90); fd(len );
                lt(90); fd(len );lt(90); fd(len );lt(90); fd(len /2);
                up();rt(90);bk(len /2);down();
                setColor(Color.BLACK);
            }
        }
    }
}
