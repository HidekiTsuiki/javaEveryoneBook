package chap03;
import tg.*;
import javafx.scene.paint.Color;
public class S33 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
	Turtle m = new Turtle(0,0,0);
	f.add(m);
	m.moveTo(400,400);
	m.up(); m.moveTo(400,0);m.down();
	m.moveTo(0,400);
	m.moveTo(200,200,0);
	m.tScale = 2.0;
	m.fd(0);
	for(;;){  
	    Point t = f.getMousePosition();
	    // 中心に原点があるかのように座標を平行移動させて考えよう。
	    double x = t.x - 200;
	    double y = t.y - 200;
	    // x + y, x - y の正負により，４つの場合が考えられる。
	    if(x + y >= 0 && x - y >= 0){ // 右
		m.tColor = Color.RED;
	    }else if (x + y < 0 && x - y < 0){ // 左
		m.tColor = Color.BLUE;
	    }else if (x + y >= 0 && x - y < 0){ // 下
		m.tColor = Color.YELLOW;
	    }else if (x + y < 0 && x - y >= 0){ // 上
		m.tColor = Color.GREEN;
	    }
	    m.fd(0);
	}
    }
}
