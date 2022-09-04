package chap05;
import tg.*;

public class P51 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        MyTurtle m = new MyTurtle();
        f.add(m);
        m.houses(5, 20, 10);
//        System.out.println(m);   //練習問題 8.8
    }
}
