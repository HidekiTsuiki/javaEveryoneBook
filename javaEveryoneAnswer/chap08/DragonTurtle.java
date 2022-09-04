package chap08;
import tg.*;

//  追加の練習問題：
//  まず，動作させてみよう。この絵を描くメソッド
//  void dragon(double length, int which, int n)
//  を作成しよう。 

public class DragonTurtle extends Turtle {
    public static void main(String[] args){
        DragonTurtle m = new DragonTurtle();
        TurtleFrame f = new TurtleFrame(400,700);
        f.add(m);
        m.up(); m.moveTo(100,20, 90); m.down();
        m.dragon(200, 1, 0);
        m.up(); m.moveTo(100,150, 90); m.down();
        m.dragon(200, 1, 1);
        m.up(); m.moveTo(100,300, 90); m.down();
        m.dragon(200, 1, 2);
        m.up(); m.moveTo(100,450, 90); m.down();
        m.dragon(200, 1, 3);

        m.up(); m.moveTo(100,650, 90); m.down();
        m.dragon(200, 1, 13);
    }

    void dragon(double length, int which, int n){
        if(n==0) fd(length);
        else{
            lt(45 * which);
            dragon(length/Math.sqrt(2), which, n-1);
            rt(90*which);
            dragon(length/Math.sqrt(2), -which, n-1);
            lt(45*which);
        }
    }
}
