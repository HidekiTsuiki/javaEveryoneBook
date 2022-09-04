package chap03;
import tg.*;
import javafx.scene.paint.Color;
public class S32 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
	Turtle m = new Turtle();
	f.add(m);
	while(m.tScale <= 2.0){
	    Point p = f.getMousePosition();
	    if(p.y < 200) m.tScale = m.tScale / 2;
	    else m.tScale = m.tScale * 2;
	    m.fd(0);
	}
	m.tColor = Color.RED;
	m.fd(200);	
    }
}
