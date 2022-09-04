package chap12;
public class CDLatch{
    private int count = 3;      //`待つ数`
    public CDLatch(int count){
        this.count = count;
    }
    synchronized void await() throws InterruptedException{
        while(count > 0){         
            wait();      //  待つ
        }
    }
    synchronized void countDown() {
        count--;
        if(count <= 0) {
            notifyAll();
        }
    }
}
