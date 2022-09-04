package chap12;
import chap05.HTurtle;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javafx.scene.paint.Color;
import tg.*;

public class BlockingQueueHouse extends TurtleFrame{
	public static void main(String[] args)    {
		new BlockingQueueHouse();
	}
	BlockingQueueHouse(){
		BlockingQueue<double[]> sl = new ArrayBlockingQueue<double[]>(3);
		SquareProducer sp =new SquareProducer(sl); add(sp);
		SquareConsumer sc =new SquareConsumer(sl); add(sc);
        new Thread(sp).start();
        new Thread(sc).start();
	}
	class SquareProducer extends HTurtle implements Runnable{
		BlockingQueue<double[]> mes;
		SquareProducer(BlockingQueue<double[]> lo){ mes = lo; } // コンストラクタ
		public void run(){
			for(int i = 0;i < 20;i++){
				speed((int)((Math.sin(i/3)+1.5)*10));
				double aa = Math.random() * 400;
				double bb = Math.random() * 400;
				up(); moveTo(aa, bb, 90); down();
				polygon(4, 20);
				try{
					mes.put(new double[]{aa,bb});
				}catch(InterruptedException e){
					Thread.currentThread().interrupt();
				}
			}
		}
	}
	class SquareConsumer extends HTurtle implements Runnable{
		BlockingQueue<double[]> mes;
		SquareConsumer(BlockingQueue<double[]> lo){ mes = lo; } // コンストラクタ
		public void run(){
			setColor(Color.RED);
			for(int i = 0;i < 20;i++){
				speed((int)((-Math.sin(i/3)+1.5)*10));
				try{
					double[] a = mes.take();
					up(); moveTo(a[0], a[1], 30); down();
					polygon(3,20);
				}catch(InterruptedException e){
					Thread.currentThread().interrupt();
				}
			}
		}
	}
}
