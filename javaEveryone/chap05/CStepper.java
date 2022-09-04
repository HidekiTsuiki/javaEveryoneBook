package chap05;
import tg.*;

public class CStepper extends Turtle{
    private int n;                        
    private double size;                    
    private int j = 0;        
    public CStepper(int n, double size){ 
        this.n = n;                  //インスタンスフィールド n に 引数 n を設定
        this.size = size;            //インスタンスフィールド size の設定
    } 
    public CStepper(int n, double size, int x, int y, int angle){
        super(x, y, angle);     //Turtle のコンストラクタ呼出し
        this.n = n;                
        this.size = size;        
    }
    public void step() {  
        if(j >= n)
            return;                //描き終えていたならすぐ終了
        fd(size);
        rt(360.0/n);
        j++;                        //j の値を 1 増やす
    }
}
