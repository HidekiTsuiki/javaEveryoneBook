package chap11;
import java.io.*;
import java.util.*;
public class ArrayListAverage1{
    List<Double> listH = new ArrayList<Double>();  
    void start(){
        readData();                  
        System.out.println(listH);   
        average();                   
        listH.sort(null);            
        System.out.println(listH);   
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
            	sc.close();
            }
        }catch(IOException error) { System.out.println("IOエラー発生"); System.exit(1);}
    } 
    void average(){     
        double sum = 0;
        //ここから
        Iterator<Double> it = listH.iterator();   //反復子を得る
        while(it.hasNext()){              //次の要素があるか確認
            sum = sum + it.next();         //次の要素を得て，合計に加える
        }
        //ここまで
        System.out.printf("総数：%d,  平均:%5.1fcm.\n", listH.size(), sum/listH.size());      
    }
    public static void main(String[] args){
        new ArrayListAverage1().start();
    }
}

