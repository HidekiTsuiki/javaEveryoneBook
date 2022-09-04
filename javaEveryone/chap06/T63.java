package chap06;
import chap05.HTurtle;
import tg.*;

public class T63 {
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame(600,300);
        HTurtle[][] tm = new HTurtle[3][]; // 配列の配列作成
        for(int i = 0 ; i < tm.length; i++){
            tm[i] = new HTurtle[i + 2];  //i 行目は i+2 の大きさで配列作成
            for(int j = 0 ; j < tm[i].length; j++){
                tm[i][j] = new HTurtle(j * 50 + 50,i * 50 + 50,0);
                f.add(tm[i][j]);
            }
        }
        for(int i = 0 ; i < tm.length; i++){
            for(int j = 0 ; j < tm[i].length; j++){
                tm[i][j].polygon(i+3, (j+1)*10);
            }
        }
    }
}
