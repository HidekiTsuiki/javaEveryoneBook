package chap09;
import chap05.HTurtle;
import tg.*;
public class P90{
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame();
      Turtle m = new HTurtle();    //HTurtle を生成して Turtle 型の m に代入
//      Turlte m = new Turtle();   // これだと， 11 行目のキャストでエラーが発生。
      f.add(m);             
      m.fd(100);       
      ((HTurtle)m).house(50);
   }
}
