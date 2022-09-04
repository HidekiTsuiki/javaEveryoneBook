package chap08;
import javafx.scene.paint.Color;
import tg.*;

public class PeanoTurtle extends Turtle{
    boolean rect = false;  // true にすると，赤い三角形も描きます。 
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame(600, 400);
        PeanoTurtle m = new PeanoTurtle();
        f.add(m);
        m.up(); m.moveTo(100,150,90); m.down();
        m.peano(200, 1, 6);
        m.up(); m.moveTo(400,150,90); m.down();
        m.peanoIsland(200, 1, 6);

        m.rect = true;
        m.up(); m.moveTo(100,350,90); m.down();
        m.peano(200, 1, 6);
        m.up(); m.moveTo(400,350,90); m.down();
        m.peanoIsland(200, 1, 6);
    }

    void peano(double len , int which, int n){
        if(n > 0){
            lt(which*45);
            peano(len /Math.sqrt(2),-which, n-1);
            rt(which*45);
            fd(len * (Math.sqrt(2)-1) / Math.pow(Math.sqrt(2),n));  // この長さの計算が難しい
            rt(which*45);
            peano(len /Math.sqrt(2), -which, n-1);
            lt(which*45);
        }else{   // 三角形を描かないなら，この else は不要。
            if(rect){
                double x = len * (Math.sqrt(2)-1)/2;
                setColor(Color.RED.brighter().brighter());
                up(); rt(90*which);fd(x);down();lt(90*which);fd(len/2);lt(135*which); fd(len/Math.sqrt(2));
                lt(90*which); fd(len/Math.sqrt(2));lt(135*which); fd(len/2);lt(90*which); 
                up();fd(x);down();rt(90*which);
                setColor(Color.BLACK);setWidth(1.0);
//                		   		setColor(Color.RED); circle(x);
            }
        }
    }
    void peanoIsland(double len , int which, int n){
        lt(45);
        peano(len, which, n);
        rt(90);
        fd(len * (Math.sqrt(2)-1) / Math.pow(Math.sqrt(2),n));
        rt(90);
        peano(len, which, n);
        rt(90);
        fd(len * (Math.sqrt(2)-1) / Math.pow(Math.sqrt(2),n));
        rt(135);
    }
    
    // 円を描くメソッド。練習問題とは無関係。
    void circle(double r){
        double x = getX(), y = getY(), a = getAngle();
        up();
        for(int i = 0; i < 360; i++){
            double xx = Math.sin(Math.toRadians(i));
            double yy = Math.cos(Math.toRadians(i));
            moveTo(x + r * xx, y + r * yy, a);
            down();
        }
        up();
        moveTo(x, y);
        down();
    }
    
    
}
