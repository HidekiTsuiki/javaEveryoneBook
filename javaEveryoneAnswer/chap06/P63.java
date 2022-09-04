package chap06;
import chap05.HTurtle;
import tg.*;

public class P63 {
  public static void main(String[] args){
    TurtleFrame f = new TurtleFrame(600,300);
    HTurtle[] hm = new HTurtle[6];           
    for(int i = 0 ; i < hm.length; i++){
      hm[i] = new HTurtle(i * 50 + 25,150,0);
      f.add(hm[i]);
    }
    for(int i = 0; i < hm.length; i++){
    	hm[i].polygon(6,10);
    }
  }
}
