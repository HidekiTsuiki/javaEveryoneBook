package chap03;
import tg.*;
import javafx.scene.paint.Color;
public class T35 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        for(int i = 0; i < 5; i++){
            if(i == 3){
                m.setColor(Color.RED);
            }
            m.fd(100);
            m.rt(72);
        }
    }	
}
