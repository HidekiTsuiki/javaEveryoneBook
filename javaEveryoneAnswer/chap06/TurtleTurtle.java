package chap06;
import javafx.scene.paint.Color;
import tg.*;

public class TurtleTurtle extends PTurtle{
    public int x = 200;
    public int y = 200;
    public int angle = 0;
    public double scale = 1.0;
    public int step = 80;

    double[][][] turtles = {Turtle.turtleFig, 
            Turtle.turtleRFig, Turtle.turtleFig, Turtle.turtleLFig};
    int which;

    TurtleTurtle(int x, int y, int angle){
        this.x = x; this.y = y; this.angle = angle;
    }
    void forward(){
        x = x + (int)(step * Math.sin(Math.toRadians(angle)));
        y = y - (int)(step * Math.cos(Math.toRadians(angle)));
        draw(trans(turtles[which%turtles.length], angle, scale), x, y);
        which++;
    }

    void rightTurn(int th){
        angle += th; 
        x = x + (int)(step * Math.sin(Math.toRadians(angle)));
        y = y - (int)(step * Math.cos(Math.toRadians(angle)));
        draw(trans(turtles[which%turtles.length], angle, scale), x, y);
        which++;
    }

    public static void main(String[] args){
        TurtleTurtle m = new TurtleTurtle(200,550,-30);
        TurtleFrame f = new TurtleFrame(800,800);
        f.add(m);
        for(int i = 0; i < 4; i++){
            m.forward();
        }
        for(int i = 0; i < 7; i++){
            m.rightTurn(30);
            m.scale *= 1.2;
            m.step *= 1.2;
        }
        try{Thread.sleep(1000);}catch(InterruptedException e){}
        Turtle m1 = new Turtle(m.x, m.y, m.angle);
	    m1.up();
        f.add(m1);
        m1.setTScale(m.scale);
        m1.speed(200);
        Turtle.withTurtleAll = true;
        Turtle.speedAll(2);        
        m1.fd(100);
        m1.rt(90);
        m1.fd(200);
        m1.rt(90);
        m1.fd(250);
        m.speed(100); 
        m.up();
        m.setTScale(1.0);
        m.moveTo(230,613,-30);
        m.speed(1000);
        m.moveTo(200,550,-30);
        try{Thread.sleep(2000);}catch(InterruptedException e){}
        m.setTColor(Color.BLACK);
    }
}