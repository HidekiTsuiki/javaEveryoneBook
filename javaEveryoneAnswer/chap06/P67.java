package chap06;
import chap05.HTurtle;
import tg.*;

public class P67 {
   public static void main(String[] args){
      int n = Integer.parseInt(args[0]);
      double s = Double.parseDouble(args[1]);
      TurtleFrame f = new TurtleFrame();
      HTurtle m = new HTurtle();
      f.add(m);
      m.polygon(n, s);
   }  
}
