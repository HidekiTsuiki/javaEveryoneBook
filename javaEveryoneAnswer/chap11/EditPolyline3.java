package chap11;
import tg.*;
import java.util.*;

public class EditPolyline3 {
    List<Point> polyline = new LinkedList<>();
    TurtleFrame f = new TurtleFrame();
    Turtle m = new Turtle();     // 位置を示すための Turtle 
    int current = -1;            // 現在の位置のインデックス。-1 は，一つも頂点がない
    EditPolyline3(){
        f.add(m);
        m.up();
        f.addControlArea();
    }
    void start(){
        while(true){
            Turtle.setWithTurtleAll(false);
            show();
            if(current >= 0){            // タートルを current 番目の頂点に描画
                Point r = polyline.get(current);
                m.moveTo(r.x, r.y);
                if(current < polyline.size()-1){   // 次の頂点があるなら，タートルの向きを，次の頂点の向きに
                    Point r1 = polyline.get(current+1);  //少し難しい計算だが，次の頂点へのの向きから現在の角度を引き算. atan2 は覚えておくと便利かも。
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
                if(polyline.size()>0){  // 頂点がなかったら，やらない。
                    Point u = Collections.min(polyline, 
                            Comparator.comparing(q-> Math.abs(q.x - r.x) + Math.abs(q.y - r.y)));
                       // 今の頂点とのマンハッタン距離が一番近いのを選ぶ
                    current = polyline.indexOf(u);
                }
            }else{   // 追加
                current++;
                polyline.add(current, p);
            }
            f.clear();
        }
    }
    void show(){
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
        new EditPolyline3().start();
    }
}



