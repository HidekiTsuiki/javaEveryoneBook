package chap11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class WordCount2 {
    String file = "sample.txt";
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    public static void main(String[] args) {
        new WordCount2().start();
    }
    void start(){
        read();
        print();
    }
    void read(){
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));){
            sc.useDelimiter("[\\P{L}]+");
            while(sc.hasNext()){
                String s = sc.next();
                Integer d = hm.get(s);
                if(d == null){
                    hm.put(s, 1);
                }else{
                    hm.put(s, d+1);
                }
            }
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    void print(){
        ArrayList<Map.Entry<String, Integer>> al = new ArrayList<>(hm.entrySet());
        al.sort(Comparator.comparing(x->-x.getValue()));
        System.out.println(al.subList(0, 10));
    }
}
