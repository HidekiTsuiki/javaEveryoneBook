package chap09;
import tg.*;
public class P101 {
    public static void main(String args[]){
        TurtleFrame f = new TurtleFrame();
        Drawable[] hm = new Drawable[4];  
        hm[0] = new DrawHouse(); f.add((Turtle)hm[0]);
        hm[1] = new DrawStar(); f.add((Turtle)hm[1]); 
        hm[2] = (double x, double y) -> {
            for(int i = 0; i < x / 10; i++){
                System.out.print("*");
            }
            for(int i = 0; i < y / 10; i++){
                System.out.print("+");
            }
            System.out.println("");new DrawText();
        };
        hm[3] = (double xx, double yy) -> {
            System.out.println(xx+ ", " + yy);
        };

        while(true){
            int n = (int)(Math.random() * hm.length);
            int x = (int)(Math.random() * 400);
            int y = (int)(Math.random() * 400);
            hm[n].draw(x, y);
        }
    }
}
