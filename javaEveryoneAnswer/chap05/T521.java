package chap05;
import tg.*;

public class T521{
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Stepper1 m1 = new Stepper1(); f.add(m1);
        Stepper1 m2 = new Stepper1(); f.add(m2);
        m1.size = 100;
        Stepper1.n = 4;  m2.size = 100;  
        m1.up(); m1.moveTo(100,200,0); m1.down();
        for(int i = 0; i < 4; i++){
            m1.step();
            m2.step();
        }
    }
}
