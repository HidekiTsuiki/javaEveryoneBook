package chap12;
public class SleepAndInterrupt {
    public static void main(String[] args)  throws InterruptedException  {
        Thread t = new Thread(()->{
            try{                    
                for(int i = 10; i >= 0; i--){
                    System.out.println("S: " + i);
                    Thread.sleep(1000);
                }                    
            }catch(InterruptedException e){
                System.out.println("S: Interrupted");
            }
        });           
        System.out.println("O: Timer Start");
        t.start();    
        Thread.sleep(6000);  
        System.out.println("O: Interrupt");  
        t.interrupt();   
    }
}
