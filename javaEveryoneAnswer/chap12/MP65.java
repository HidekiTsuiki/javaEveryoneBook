package chap12;
import tg.*;
import chap05.HTurtle;
import javafx.scene.paint.Color;

public class MP65 {
    public static void main(String[] args){
        double[] size = {20, 40, 20, 60};
        int[] n = {7, 5, 3, 4, 6};
        Color[] c = {Color.ORANGE, Color.RED, Color.BLUE};

        TurtleFrame f = new TurtleFrame(600,300);
        for(int i = 0 ; i < 10; i++){
            int ii = i;
            new Thread(()->{
                HTurtle m = new HTurtle(ii * 50 + 25,150,0); 
                m.setColor(c[ii%c.length]);
                f.add(m);
                int nn = n[ii%n.length];
                m.polygon(nn, size[ii%size.length]);
            }).start();
        }
    }
}
