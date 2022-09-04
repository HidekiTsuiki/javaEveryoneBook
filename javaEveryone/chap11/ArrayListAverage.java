package chap11;
import java.io.*;
import java.util.*;
public class ArrayListAverage{
    List<Double> listH = new ArrayList<Double>();        //List型変数の宣言とArrayListの生成
    void start(){
        readData();                         //データを読み込み
        System.out.println(listH);     //データを表示
        average();                          //平均値の計算・表示
        listH.sort(null);                 //データをソート
        System.out.println(listH);     // データを再表示
    }
    void readData(){       
        String entry;
        double weight=0, height = 0;
        String name = "";
      try(BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));){
//        try(BufferedReader din = new BufferedReader(new FileReader(getClass().getResource("/listdata.txt").getPath()));){
//  このようにリソースとして listdata.txt を扱う時には，listdata.txt は src フォルダに移動する必要があります。
    	  while ((entry=din.readLine()) != null) {                 //ファイルから1行読む
        		Scanner sc = new Scanner(entry);                        //値を切り出すためScannerを使う
        		if(sc.hasNext()) name = sc.next();                    //名前を取り出す(使わない)
        		if(sc.hasNextDouble()) weight = sc.nextDouble(); // 体重を取り出す(使わない)
        		if(sc.hasNextDouble())height = sc.nextDouble();  //身長を取り出す
        		listH.add(height);                                          //ArrayListに身長の値を入れる
        		sc.close();
        	}
        }catch(IOException error) { System.out.println("IOエラー発生"); System.exit(1);}
    } 
    void average(){        
        double sum=0;
        for(Double x: listH){ // 拡張for文
            sum = sum + x;      //身長の合計計算
        }                  
        System.out.printf("総数：%d,  平均:%5.1fcm.\n", listH.size(), sum/listH.size());      
    }
    public static void main(String[] args){
        new ArrayListAverage().start();
    }
}

