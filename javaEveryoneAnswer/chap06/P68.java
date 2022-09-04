package chap06;
import chap05.HTurtle;
import tg.*;

public class P68 {
   public static void main(String[] args){
      int n = 6;
      double s = 100;
      if(args.length > 0) n = Integer.parseInt(args[0]);
      if(args.length > 1) s = Integer.parseInt(args[1]);
      TurtleFrame f = new TurtleFrame();
      HTurtle m = new HTurtle();
      f.add(m);
      m.polygon(n,  s);
   }  
}
