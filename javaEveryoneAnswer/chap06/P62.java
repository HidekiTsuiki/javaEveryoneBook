package chap06;
import chap05.HTurtle;
import tg.TurtleFrame;

public class P62 {
   public static void main(String[] args){
      TurtleFrame f = new TurtleFrame(600,300);
     HTurtle[] hm = new HTurtle[10];            // 配列オブジェクトを生成
      for(int i = 0 ; i < 10; i++){
         hm[i] = new HTurtle(i * 50 + 25,150,0); // HTurtle を生成，配列の各要素に代入
         f.add(hm[i]);
      }   
      for(int i = 0; i < 10; i++){  
         hm[i].polygon(i+3, 10);   // hm[i] に代入されている HTurtle へのメソッド呼び出し
      }  
  }
}
