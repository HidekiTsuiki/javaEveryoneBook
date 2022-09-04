package chap03;
import tg.*;
public class S31 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
	Point p = f.getMousePosition();
	Turtle m = new Turtle(p.x, p.y, 0);
	f.add(m);
	int i = 1;
	while((0 <= m.getX()  && m.getX() <= 400) &&
	      (0 <= m.getY()  && m.getY() <= 400)){
	    m.fd(i * 10);
	    m.rt(72);
	    i++;
	}
    }
}
