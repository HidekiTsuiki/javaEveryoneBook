package chap08;
import tg.*;

public class SierpinTurtle extends Turtle{
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame(400,700);
        SierpinTurtle m = new SierpinTurtle();
        f.add(m);
        m.up();m.moveTo(120,300, 90); m.down();
        m.sierpin(200, 5);
        m.up();m.moveTo(120,600, 90); m.down();
        m.sierpin2(200, 1, 5);
    }
    void sierpin(double len , int n){
        if(n == 0){
            fd(len );lt(120);fd(len );lt(120);fd(len );lt(120); // 三角形
        }else{
            sierpin(len /2, n-1);   // 1/2 の大きさでレベル n-1 のものを
            fd(len /2);             // 場所を移動して
            sierpin(len /2, n-1); 
            lt(120);fd(len /2);rt(120);   // 場所を移動して
            sierpin(len /2, n-1); 
            lt(60);bk(len /2);rt(60);   // 元の場所に戻る
        }
    }
    void sierpin2(double len , int which, int n){
        if(n == 0){
            fd(len );
        }else{
            lt(which*60);sierpin2(len /2, -which, n-1); 
            rt(which*60);sierpin2(len /2, which, n-1); 
            rt(which*60);sierpin2(len /2, -which,n-1); 
            lt(which*60);
        }
    }
}
