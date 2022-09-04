package chap05;
import tg.*;

public class HTurtle1 extends Turtle {      //Turtle を拡張する 
    public double polygon(int n, double s){      //polygonメソッドの定義 
        double a = 360.0/n;                             //曲がる角度を求めておく 
        for(int j = 0; j < n; j++){            //n 回繰り返す 
            fd(s);                                    //s 前に進んで 
            rt(a);                                    //a 曲がるのを 
         }
         return n * s;      
    }
    public double house(double s){    //house メソッドの定義 
        double len = 0;
        len = polygon(4, s);                              //polygon を利用 
        fd(s); 
        rt(30);
        len += polygon(3, s);
        lt(30); 
        bk(s);                             //もとの場所に戻しておく
        return len;
    }

   // コンストラクター，練習問題7.8で追加。 
   public HTurtle1(double x, double y, double angle){
      super(x, y, angle);
   }
   public HTurtle1(){
      super();
   }
} 
