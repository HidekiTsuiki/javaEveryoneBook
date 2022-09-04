package chap11;
import java.util.*;
import java.io.*;
public class SortedMapView{
    Map<String, HData> map = new TreeMap<>();  // TreeMap に変更
    Set<String> keyview = map.keySet();
    void start(){
        readData();
        search("緑田");  
    }
    void readData(){       
        String entry;
        double weight=0, height = 0;
        String name = "";
        try(BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));){
            while ((entry=din.readLine()) != null) {             
                Scanner sc = new Scanner(entry);                 
                if(sc.hasNext()) name = sc.next();               
                if(sc.hasNextDouble()) weight = sc.nextDouble(); 
                if(sc.hasNextDouble())height = sc.nextDouble();  
                map.put(name, new HData(name, weight, height));  
                sc.close();              
                System.out.println(keyview);
            }
        }catch(IOException error) { System.out.println("IOエラー発生"); System.exit(1);}
    } 
    void search(String nn){
        HData r = map.get(nn);             
        if(r==null){System.out.println(nn + "さんのデータはありません");} 
        else {System.out.println(r); }     
    }
    public static void main(String[] args){
        new SortedMapView().start();
    }
    class HData{
        String name;  double weight;  double height;  
        HData (String name, double weight, double height){
            this.name = name; this.weight = weight;  this.height = height;
        }
        @Override  public String toString(){
            return("("+ name + ":" + weight+", "+ height +")");
        }
    }
}
