package chap12;
import chap05.HTurtle;
import java.util.concurrent.*;
import tg.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        TurtleFrame f = new TurtleFrame();
        Future<Double> x1 = executor.submit(()->{
            HTurtle m = new HTurtle(100,200,0); f.add(m);
            return m.polygon(5, 50);
        });
        Future<Double> x2 = executor.submit(()->{
            HTurtle m = new HTurtle(200,200,0);  f.add(m);
            return m.polygon(7, 50);
        });
        executor.shutdown();
        System.out.println("get の呼び出し");
        double v = x1.get()+ x2.get();
        System.out.println("get の値:" + v); 
    }
}
