package chap12;
import chap05.HTurtle;
import tg.*;

public class MPolygonL4{
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        HTurtle m = new SHTurtle();     // SHTurtle の呼び出し
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
