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
    public static void main(String[] args){    // 練習問題 5.12
        TurtleFrame f = new TurtleFrame();
        CStepper m1 = new CStepper(4, 100); f.add(m1);
        CStepper m2 = new CStepper(3, 100, 100, 200, 0); f.add(m2);
        for(int i = 0; i < 4; i++){
            m1.step();
            m2.step();
        }
    }
}
