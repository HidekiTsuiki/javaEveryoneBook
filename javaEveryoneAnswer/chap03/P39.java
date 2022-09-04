package chap03;
import tg.*;

public class P39 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle m = new Turtle(150,100,0);
        f.add(m);
        for(int j = 0; j < 8; j++){
            m.fd(25);      
            m.rt(45);
            for(int i = 0; i < j+3; i++){
                m.fd(25);
                m.lt(180-(j+1)*180.0/(j+3));
            }
        }
    }
}
