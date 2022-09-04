package chap03;
import tg.*;

public class P35 {
    public static void main(String[] args){
        int n = 8, k = 5;
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        for(int j = 0; j < n; j++){
            for(int i = 0; i < k; i++){
                m.fd(50);
                m.lt(360.0/k);
            }
            m.fd(50);
            m.rt(360.0/n);
        }
    }
}
