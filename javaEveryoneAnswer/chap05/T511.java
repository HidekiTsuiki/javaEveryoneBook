package chap05;
import tg.*;

public class T511 {
    public static void main(String[] args){
        double len = 0;
        TurtleFrame f = new TurtleFrame();
        HTurtle1 m = new HTurtle1();  
        double size = 50;
        f.add(m);    
        len += m.house(size);  
        m.up(); m.lt(90); m.fd(50); m.rt(72); m.down();  
        len += m.polygon(5, size / 2); 
        m.up(); m.moveTo(100,100,0); m.down();  
        len += m.polygon(10, size / 5);
        System.out.println(len);
    }
}
