package chap03;
import tg.*;
import javafx.scene.paint.Color;
public class T38 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        for(int i = 0; i < 12; i++){
            switch (i % 3) {
            case 0:
                m.setColor(Color.RED);
                break;
            case 1:
                m.setColor(Color.GREEN);
                break;
            case 2:
                m.setColor(Color.YELLOW);
                break;
            }
            m.lt(30);  m.fd(50);
        }
    }	
}
