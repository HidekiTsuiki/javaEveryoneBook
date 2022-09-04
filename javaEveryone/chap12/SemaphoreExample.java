package chap12;
import chap05.HTurtle;
import tg.*;
import java.util.concurrent.*;

import javafx.scene.paint.Color;

public class SemaphoreExample extends TurtleFrame{ 
    SemaphoreExample(int n){
        ExecutorService executor = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(2, true); 
        for(int ii = 0; ii < n; ii++){
            int i = ii;
            executor.execute(()-> {
                HTurtle m = new HTurtle(100,50*(i+1),90);  add(m);
                try{
                    for(int k = 0; k < 5; k++){
                        sp.acquire();       
                        m.speed((int)(Math.random() * 60)+1);      m.setTColor(Color.RED);
                        m.polygon(i+3, 20);    m.fd(20);             m.setTColor(Color.LIME);
                        sp.release();  
                    }
                    executor.shutdownNow(); 
                }catch(InterruptedException e){}
            });
        }
        executor.shutdown();
    }
    public static void main(String[] args)    {
        new SemaphoreExample(5); 
        new SemaphoreExample(3); 
    }
}
