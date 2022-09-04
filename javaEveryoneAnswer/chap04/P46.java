package chap04;
import tg.*;                                 
import javafx.scene.paint.*;
public class P46{
    public static void main(String[] args){
        double d = 100, x, y, a;
        TurtleFrame f = new TurtleFrame(); 
        Turtle m = new Turtle(200, 300, 0);
        f.add(m);                           
        m.fd(d);                            
        x = m.getX();                    
        y = m.getY();                    
        a = m.getAngle() - 45;      
        Turtle m1 = new Turtle(x, y, a); 
        f.add(m1);                     
        m1.fd(d);
        Turtle m2 = m.clone();   
        f.add(m2);                     
	System.out.println("(" + m2.getX() + ", " + m2.getY() + ")");
        m.rt(45);                      
        m.fd(d);
        double newscale = m2.tScale * 4; 
        m2.tScale = newscale;                 
        m2.tColor = new Color(0.0, 1.0, 1.0, 1.0); 
        m2.fd(d);                   
	System.out.println("(" + m2.getX() + ", " + m2.getY() + ")");
        Point p = f.getMousePosition(); 
        m2.moveTo(p.x, p.y);        
	System.out.println("(" + m2.getX() + ", " + m2.getY() + ")");
    }
}
