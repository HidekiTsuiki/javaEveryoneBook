package chap12;
import chap05.HTurtle;
import tg.*;
public class MPolygonL2{
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        for(int i = 0; i < 5; i++){
             int ii = i; 
             new Thread(()->{
                  HTurtle m = new HTurtle((ii +1)* 50, 200, 0);    f.add(m);
                  m.polygon(5,30);
            }).start();
        }
    }
}
