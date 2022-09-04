package chap11;
import tg.*;
import java.util.*;

// 練習問題11.13：  (分かりづらいので教科書からは削除しました。)
// 折れ線の集まりは，List<List<Point>> として表現できる。折れ線の集まりを編集できるようにしよう。
// 青いコントロールエリアが２回連続してクリックされたら，
// 新しい折れ線を追加して，その編集が始まるようにしよう(EditPolyline4.java)


public class EditPolyline4 {
    List<List<Point>> polypolyline = new LinkedList<>();  // リストのリストにする
    List<Point> polyline = new LinkedList<>();    //現在見ている折れ線
    int current = -1;            // 現在見ている折れ線の中での現在の位置のインデックス。-1 は，一つも頂点がない
    TurtleFrame f = new TurtleFrame();
    Turtle m = new Turtle();     // 位置を示すための Turtle 
    EditPolyline4(){
        polypolyline.add(polyline);
        f.add(m);
        m.up();
        f.addControlArea();
    }
    void start(){
        while(true){
            Turtle.setWithTurtleAll(false);
            show1();
            if(current >= 0){            // タートルを current 番目の頂点に描画
                Point r = polyline.get(current);
                m.moveTo(r.x, r.y);
                if(current < polyline.size()-1){   // 次の頂点があるなら，タートルの向きを，次の頂点の向きに
                    Point r1 = polyline.get(current+1);  //少し難しい計算だが，次の頂点へのの向きから現在の角度を引き算. atan2 は覚えておくと便利。
                    m.rt(((Math.atan2(r1.x - r.x, -( r1.y - r.y))/Math.PI) * 180) - m.getAngle());
                }
                Turtle.setWithTurtleAll(true);  // タートルを見えるようにする。
            }
            // ここまでが描画
            
            Point p = f.getMousePosition();    // ここで，次のマウスのクリックを待っている。
            if(p.x < 10 && p.y < 10){   // 削除
                if(current >= 0){
                    polyline.remove(current);
                    if(current > 0 || polyline.size() == 0){
                        current--;            // 削除した時には一つ前の頂点。最初の頂点(current=0)で，長さが0 の時には -1 （頂点なし）になる
                    }
                }
            }else if(p.x < 20 && p.y < 10){  // 編集点を変更
                Point r = f.getMousePosition();    // 編集頂点のマウスでのクリックを待つ。
                if(r.x < 20 && r.y < 10){  // コントロールエリアだったら，新しい polyline を作成
                    polyline = new LinkedList<>();
                    polypolyline.add(polyline);
                    current = -1;
                }else{
                    //全部のノードのリストを all に作成
                    setClosestFromAll(r);
                }
            }else{   // 追加
                current++;
                polyline.add(current, p);
            }
            f.clear();
        }
    }
    void setClosestFromAll(Point r){  // ｒと一番近いものに，polyline と current を設定
        List<Point> all = new ArrayList<>();
        polypolyline.forEach(all::addAll);   // 難しいが，これで all に全て入る
        if(all.size()==0) return;  // 頂点がなかったら，やらない。
        Point u = Collections.min(all, 
                Comparator.comparing(q-> Math.abs(q.x - r.x) + Math.abs(q.y - r.y)));
       // 今の頂点とのマンハッタン距離が一番近いのを all から選ぶ
        for(List<Point> p1 :polypolyline){  // 実際にどのpolyline がその点を含むか調べる
            if(p1.contains(u)){
                polyline = p1;
                current = p1.indexOf(u);
                return;
            }
        }
    }
    
    void show1(){ 
        for(List<Point> poly: polypolyline){
            show(poly);
        }
    }
    void show(List<Point> polyline){
        Turtle m = new Turtle();
        f.add(m);
        m.up();
        for(Point p : polyline){
            m.moveTo(p.x, p.y);
            m.down();
        }
        f.remove(m);
    }
    public static void main(String[] args){
        new EditPolyline4().start();
    }
}



