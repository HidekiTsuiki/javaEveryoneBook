package graph;
import tg.*;
import math.Newton;

public class NewtonGraph extends TurtleFrame{
	double width = 400;
	double a = 3.5;
	double fun (double x){
	    return Newton.newton(x);
	}
	GTurtle m;
    NewtonGraph(){
	    m = new GTurtle(); 
	    add(m);
    }
	void start(){
		m.drawGraph();
	}
	public static void main(String[] args){
		new NewtonGraph().start();
	}
	class GTurtle extends Turtle{
		void dMoveTo(double x, double y){
			moveTo(x *width, (1- y) * width);
		}
		void drawGraph(){
			up();
			for(double x = 0; x < 1; x+= 1/width){
				dMoveTo(x, fun(x));
				down();
			}
		}
	}
}
