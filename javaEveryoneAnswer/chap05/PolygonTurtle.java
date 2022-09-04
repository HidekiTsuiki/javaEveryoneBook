package chap05;
import tg.*;

public class PolygonTurtle extends HTurtle{ 
    private int n = 3;
    private int len = 50;
    public void draw(){ 
        double s = len * Math.sin(Math.PI/n) * 2;
        polygon(n, s);
        n++;
    }

    // 練習問題 5.8 で追加。
    public static void main(String[] args){
	int n = 10;
	TurtleFrame f = new TurtleFrame(800,400);
	PolygonTurtle p = new PolygonTurtle();
	f.add(p);
	p.rt(90);
	for(int i = 1; i < n; i++){
	    p.draw();
	    p.fd(100);
	}
    }
}

 
