package chap08;
import tg.*;

public class LevyTurtle extends Turtle{
    LevyTurtle(double x, double y, double a ){super(x, y, a);}
    void levy(double len, int n){
        if(n==0){                      //n = 0 なら
            fd(len);                     //len の長さだけ線を引いて先に進む。
        }else{                         // n $>$ 0 なら
            lt(45);                      //右に 45度向きを変えて
            levy(len/Math.sqrt(2), n-1); //$1/\sqrt{2}$ の大きさのレベル n-1 のレヴィ曲線を描き，
            rt(90);                      //左に 90 度向きを変えて
            levy(len/Math.sqrt(2), n-1); //$1/\sqrt{2}$ の大きさのレベル n-1 のレヴィ曲線を描き
            lt(45);                      //右に 45 度向きを変える
        }
    }
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame();
        LevyTurtle m = new LevyTurtle(100,300, 90);
        f.add(m);
        m.levy(200, 5);
    }
}
