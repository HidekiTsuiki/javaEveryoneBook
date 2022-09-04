package chap05;

public class MyTurtle extends HTurtle{
    /** n 軒の家を大きさ s で w の間隔で描く。
        コメントが2文以上になっている場合，javadoc は，1つ目だけを概要に載せる。*/ 
    public void houses(int n, double s, double w){
        for(int i = 0; i < n; i++){
            house(s);
            rt(90); up(); fd(w+s); down(); lt(90);
        }
    }

    /** n 角形の周りにm 角形を1辺の長さ s で描く。*/ 
    public void pPolygon(int n, int m, double s){
        for(int j = 0; j < n; j++){
            polygon(m, s);
            fd(s);
            lt(360/n);
        }
    }

    /** 1辺の長さ s の n 角形を r 枚回しながら描く。*/ 
    public void flower(int n, int r, double s){
        for(int j = 0; j < r; j++){
            polygon(n, s);
            rt(360/r);
        }
    }
    /** 1辺の長さ s の n 角形を r 枚回しながら描く(続き（2文目以降）は詳細へ)。
        n 角形の一つの辺は，回転の中心から l だけ移動した場所から
        d だけ右回転した方向に始まる。*/ 
    public void rflower(int n, int r, double s, double l, double d){
        for(int j = 0; j < r; j++){
            up(); fd(l);rt(d);down();
            polygon(n, s);
            up(); lt(d);bk(l);down();
            rt(360/r);
        }
    }

    /** (x, y) を左下の座標にし，1辺の長さ s で家の絵を描く。*/ 
    public void house(double s, double x, double y){
        up(); moveTo(x, y, 0); down();
        house(s);
    }

    public void houses(int n, double s, double w, double x, double y){
        up(); moveTo(x, y, 0); down();
        houses(n, s, w);
    }

    /** コンストラクタ，練習問題 5.13 で追加。*/
    public MyTurtle(double x, double y, double angle){
        super(x, y, angle);
    }
    /** このコンストラクタがないと，サブクラスでデフォルトのコンストラクタが使えなくなる。*/
    public MyTurtle(){
        super();
    }
}
