package chap12;
import chap05.HTurtle;
import java.util.concurrent.*;
import tg.*;

public class CDLatchExample2 extends TurtleFrame{
    ExecutorService executor = Executors.newCachedThreadPool();
    CDLatchExample2(int num, CDLatch start, CDLatch finish){
        for(int i = 0; i < num; i++){
            int ii = i;
            executor.execute(()->{
                Turtle m = new HTurtle(0, (ii+1)*50, 90);    add(m);
                int sp = (int)((Math.random()+1)*20);
                m.speed(sp);
                try {
                    start.await();   // それぞれのタートルが start のカウントダウンを待つ
                    m.fd(400);
                    finish.countDown();  // 全てのタートルが，finish のカウントダウンを行う
                } catch (InterruptedException e) {}
            });
        }
        executor.shutdown();
    }
    public static void main(String[] args) throws InterruptedException {
        CDLatch c1 = new CDLatch(1);  // スタートのタイミングを合わせるため
        CDLatch c2 = new CDLatch(2);  // 1つ目のレースの２位が到着したら次のレースがスタート
        CDLatch c3 = new CDLatch(2);  // 2つ目のレースの２位が到着したら次のレースがスタート
        CDLatch c4 = new CDLatch(1);  // 誰かがゴールしたら，コンソールに GOAL と表示
        CDLatchExample2 a1= new CDLatchExample2(5, c1, c2); 
        CDLatchExample2 a2= new CDLatchExample2(3, c2, c3);
        CDLatchExample2 a3= new CDLatchExample2(7, c3, c4);
        c1.countDown();         // c1 をカウントダウンし，レースがスタート
        c4.await();              // c4 がカウントダウンされるまで待つ
        System.out.println("GOAL");
    }
}
