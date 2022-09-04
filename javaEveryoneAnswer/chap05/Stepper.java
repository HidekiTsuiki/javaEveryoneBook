package chap05;
import tg.*;

public class Stepper extends Turtle{
    public int n;                         //公開されたインスタンスフィールド n の宣言 
    public double size;                //公開されたインスタンスフィールド size の宣言 
    private int j = 0;              //（非公開）インスタンスフィールド j の宣言 
    public void step() {  
        if(j >= n)
            return;                //描き終えていたならすぐ終了
        fd(size);
        rt(360.0/n);
        j++;                        //j の値を 1 増やす
    } 
    public static void main(String[] args){   // 練習問題 5.8 で追加
        TurtleFrame f = new TurtleFrame();
        Stepper m1 = new Stepper(); f.add(m1);
        Stepper m2 = new Stepper(); f.add(m2);
        m1.size = 100;
        Stepper1.n = 4;  m2.size = 100;  
        m1.up(); m1.moveTo(100,200,0); m1.down();
        for(int i = 0; i < 4; i++){
            m1.step();
            m2.step();
        }
    }
}
