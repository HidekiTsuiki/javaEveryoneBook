package chap03;
import tg.*;

public class Mouse32 {         
    public static void main(String[] args){
        TurtleFrame f =  new TurtleFrame();  
        Turtle m = new Turtle();
        f.add(m);              
	f.addControlArea();
        for(;;){
            Point p = f.getMousePosition();
	    if(p.x < 10 && p.y < 10) break;
            m.moveTo(p.x, p.y);
        }
        f.remove(m);
        System.out.println("Program finished.");
    }
}
