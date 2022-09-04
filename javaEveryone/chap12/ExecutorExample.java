package chap12;
import chap05.HTurtle;
import tg.*;
import java.util.concurrent.*;

public class ExecutorExample{
    public static void main(String[] args){
        TurtleFrame f = new TurtleFrame();
        Turtle.speedAll(4);
//        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executor = Executors.newWorkStealingPool();
        for(int i = 0; i < 25; i++){
            int ii = i;
            executor.execute(()->{ 
                HTurtle m = new HTurtle((ii %5+1)* 50, (ii/5+1)*50, 0);    
                f.add(m);
                m.speed((int)(Math.random()*40+1));
                m.polygon(5,10);
                f.remove(m);
            });
        }
        executor.shutdown(); 
    }
}
