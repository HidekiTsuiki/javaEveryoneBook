package chap12;
import chap05.HTurtle;

public class SHTurtle extends HTurtle{
	@Override
	synchronized public double polygon(int n, double s){
		return super.polygon(n, s);
	}
	@Override
	synchronized public void house(double s){
		super.house(s);
	}
}
