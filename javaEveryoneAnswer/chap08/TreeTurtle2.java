package chap08;
import tg.*;

public class TreeTurtle2 extends Turtle{
    double scaleFrom = 0.6;        // 育つ枝の長さの比率の最小値
    double scaleTo = 0.8;        // 育つ枝の長さの比率の最大値
    double minlen = 2;
    double angle = 30;        
    TreeTurtle2(double x, double y, double a ){super(x, y, a);}   // コンストラクター 
    void tree(double len){
        if(len > minlen){
            fd(len);               // 幹を描く 
            lt(angle);             // 左に向きを変える
            double scale = scaleFrom + Math.random() * (scaleTo - scaleFrom);
            tree(len*scale);  //幹の長さ len*scale, レベル n-1 の木の絵を描く
            rt(angle*2);           //右に向きを変える
            scale = scaleFrom + Math.random() * (scaleTo - scaleFrom);
            tree(len*scale);  //幹の長さ len*scale, レベル n-1 の木の絵を描く
            lt(angle);             // 向きを戻す
            bk(len);               // 最初の位置に戻る
        }
    }
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame();
        TreeTurtle2 m = new TreeTurtle2(200,400, 0);
        f.add(m);
        m.tree(100);  // 幹の長さ 100, レベル 5 の木の絵の描画
    }
}