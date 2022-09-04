package chap02;
import tg.*; 
public class P21 {   
    public static void main(String[] args){
        TurtleFrame f;                 
        f =  new TurtleFrame();    
        Turtle m = new Turtle();   
        Turtle m1 = new Turtle(); 
        f.add(m);                        
        f.add(m1);                      
        m.bk(100.0);                  
        m.lt(90.0);                      
        f.addMesh();
        m.bk(150.0);                  
        m1.lt(90.0);                    
        f.clear();
        m.bk(300.0);                
        m1.fd(300.0);                
	
    }     
}        
