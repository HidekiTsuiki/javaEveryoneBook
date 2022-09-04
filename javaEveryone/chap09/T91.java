package chap09;
import chap05.HTurtle;
import tg.*;
public class T91{
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame();
      Turtle m = new HTurtle();    //HTurtle を生成して Turtle 型の m に代入
      f.add(m);             
      m.fd(100);       
 //  m.house(50); 
   }
}
