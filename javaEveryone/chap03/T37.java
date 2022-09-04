package chap03;
import tg.*;
import javafx.scene.paint.Color;
public class T37 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        for(int i = 0; i < 12; i++){
            if(i % 3 == 0){                 // i が 3 の倍数のとき
                m.setColor(Color.RED);
            }else if (i % 3 == 1) {      // i が 3 で割って余り1のとき
                m.setColor(Color.GREEN);
            }else{                             // それ以外（3 で割って余り2）のとき
                m.setColor(Color.YELLOW);
            }
        m.lt(30);
        m.fd(50);
    }
    }	
}
