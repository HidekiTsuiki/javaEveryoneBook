package chap02;
import tg.*;                         
public class P22 {
    public static void main(String[] args){     
        double x = 50.0, y = 100.0, d = 200.0;             
        TurtleFrame f = new TurtleFrame(700.0, 500.0);
        Turtle m = new Turtle(x, y, 180.0);    
        Turtle m1 = new Turtle(x+d, y+d, 0.0);
        javafx.scene.paint.Color c = new javafx.scene.paint.Color(0.8, 0.0, 0.0, 1.0); 
        m1.setColor(c); 
        f.add(m);                                   
        f.add(m1);                                 
        m.fd(d);                                    
        m1.fd(d);                                  
        m.lt(90.0);                                
        m1.lt(90.0);                              
        d = d / 2;         
        m.fd(d);                                          
        m1.fd(d);                                        
        m1.moveTo(m);                              
    }
}
