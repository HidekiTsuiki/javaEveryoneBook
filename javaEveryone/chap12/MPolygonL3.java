package chap12;
import chap05.HTurtle;
import tg.*;

public class MPolygonL3{
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        HTurtle m = new HTurtle(); 
//        HTurtle m = new SHTurtle();    //練習問題12.5: 傍注のように，synchronized を HTurtle に追加する代わりに，SHTurtle を利用
        f.add(m);
        new Thread(()->{
              m.polygon(3, 50); 
              m.house(50);
        }).start(); 
        new Thread(()->{
              m.polygon(5, 40); 
              m.house(40);
        }).start();
        System.out.println("Main メソッドは終了する。");  
    }
}
