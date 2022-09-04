package chap08;
import tg.*;

public class TreeTurtle extends Turtle{
    double scale = 0.7;        // 育つ枝の長さの比率
    double angle = 30;            // 枝の広がる角度
    TreeTurtle(double x, double y, double a ){super(x, y, a);}   // コンストラクター 
    void tree(double len, int n){
        if(n > 0){
            fd(len);               // 幹を描く 
            lt(angle);             // 左に向きを変える
            tree(len*scale, n-1);  //幹の長さ len*scale, レベル n-1 の木の絵を描く
            rt(angle*2);           //右に向きを変える
            tree(len*scale, n-1);  //幹の長さ len*scale, レベル n-1 の木の絵を描く
            lt(angle);             // 向きを戻す
            bk(len);               // 最初の位置に戻る
        }
    }
    public static void main(String[] args) {
        TurtleFrame f = new TurtleFrame();
        TreeTurtle m = new TreeTurtle(200,400, 0);
        f.add(m);
        m.tree(100, 5);  // 幹の長さ 100, レベル 5 の木の絵の描画
    }
}