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
}
