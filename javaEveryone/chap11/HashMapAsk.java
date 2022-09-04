package chap11;
import java.util.*;
import java.io.*;
public class HashMapAsk{
    Map<String, HData> map = new HashMap<>();  //HashMapを生成
    void start(){
        readData();
        search("緑田");  
    }
    void readData(){       
        String entry;
        double weight=0, height = 0;
        String name = "";
        try (BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));){
            while ((entry=din.readLine()) != null) {             
                Scanner sc = new Scanner(entry);                 
                if(sc.hasNext()) name = sc.next();               
                if(sc.hasNextDouble()) weight = sc.nextDouble(); 
                if(sc.hasNextDouble())height = sc.nextDouble();  
                map.put(name, new HData(name, weight, height));   // Mapに要素をput
        		sc.close();
            }
        }catch(IOException error) { System.out.println("IOエラー発生"); System.exit(1);}
    } 
    void search(String nn){
        HData r = map.get(nn);                         //Mapからキーの値を検索
        if(r==null){System.out.println(nn + "さんのデータはありません");} 
        else {System.out.println(r); }              //検索の結果を表示
    }
    public static void main(String[] args){
        new HashMapAsk().start();
    }
    class HData{ //データ保持用のクラス
        String name;  double weight;  double height;  
        HData (String name, double weight, double height){
            this.name = name; this.weight = weight;  this.height = height;
        }
        @Override  public String toString(){
            return("("+ name + ":" + weight+", "+ height +")");
        }
    }
}
