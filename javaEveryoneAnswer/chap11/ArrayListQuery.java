package chap11;
import java.io.*;
import java.util.*;
public class ArrayListQuery{
    List<Double> listH = new ArrayList<Double>(); 
    List<String> listN = new ArrayList<String>();        //ListNの用意
    void start(){
        readData();                       
        System.out.println(getHeight("緑田"));                        
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
                listH.add(height);                               
                listN.add(name);                   //ListNへの代入
            	sc.close();
            }
        }catch(IOException error) { System.out.println("IOエラー発生");System.exit(1);}
    } 
    double getHeight(String s){        //getHeight メソッド
        int i = listN.indexOf(s);
        return listH.get(i);
    }
    public static void main(String[] args){
        new ArrayListQuery().start();
    }
}

