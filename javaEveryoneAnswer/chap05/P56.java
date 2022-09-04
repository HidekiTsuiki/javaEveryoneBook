package chap05;
import tg.*;

public class P56 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame(1000,500);
        Turtle.setWithTurtleAll(false);
        for(int n = 3; n < 7; n++){
            for(int r = 2; r <= 10; r++){
                // MyTurtle を4 x 9 個作成することにする。
                MyTurtle m = new MyTurtle((r-1) *100,(n-2) * 100,0);
                f.add(m);
                m.flower(n, r, 20);
            }
        }
    }
}
