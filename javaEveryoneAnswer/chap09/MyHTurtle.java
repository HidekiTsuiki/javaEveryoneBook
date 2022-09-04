package chap09;

import chap05.MyTurtle;

public class MyHTurtle extends MyTurtle{
	@Override
   public void house(double s){
      super.house(s);
      up(); rt(90); fd(s/4); lt(90); fd(s/4); down();
      polygon(4, s/2);
      up(); bk(s/4); rt(90); bk(s/4); lt(90); down();
   }
}
