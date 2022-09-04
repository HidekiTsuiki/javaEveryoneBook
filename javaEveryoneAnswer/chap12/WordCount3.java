package chap12;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class WordCount3 {
	String path = "tg";
//	String path = "src/tg";   Eclipse 版の場合には，tg フォルダは src の中にあります。
    Map<String, Integer> hm = new ConcurrentHashMap<String, Integer>();
    ExecutorService executor = Executors.newWorkStealingPool();
    public static void main(String[] args) throws InterruptedException {
        new WordCount3().start();
    }
    void start() throws InterruptedException{
        // Callable のリストしか，invokeAll で使えないので，void ではなく，null を返すことにし，Call<Object> 型とする
        ArrayList<Callable<Object>> p = new ArrayList<>();
        String[] files = new File(path).list();  // ファイル名の配列をとりだし，
        System.out.println(files);
        // 拡張された for 文の変数は実質的に final 
        for (String file:files){  // それぞれのファイルについて
            p.add(()->{
                try(Scanner sc = new Scanner(new BufferedReader(new FileReader(path + "/" + file)));){
                    sc.useDelimiter("[\\P{L}]+");
                    while(sc.hasNext()){
                        String s = sc.next();
                        hm.merge(s, 1, (x,y)->x+y);   // merge で Map を一度に更新!
                    }
                }catch(IOException e){System.out.println(e.getMessage());}
                return null;
            });
        }
        executor.invokeAll(p);  // 全てのスレッドが終わってから次にいく。

        ArrayList<Map.Entry<String, Integer>> al = new ArrayList<>(hm.entrySet());
        al.sort(Comparator.comparing(x->-x.getValue()));
        System.out.println(al.subList(0, 10));
    }
}
