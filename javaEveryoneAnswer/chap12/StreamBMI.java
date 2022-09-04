package chap12;
import java.io.*;
import java.util.*;
public class StreamBMI{
	Map<String, HData> map = new HashMap<>();  //`\label{S4-1}HashMapを生成`
	void start(){
		readData();
        System.out.println("BMI25以上の人:"
                + "");
        bmi25();
        System.out.println("BMIの低い方から３人:");
        bmihigh();
	}
    void bmi25(){
        map.values().stream()
        .filter(p-> p.getWeight() *10000/ p.getHeight() / p.getHeight()  >= 25)
        .map(p-> p.name)
        .forEach(System.out::println);
    }

    void bmihigh(){
        map.values().stream()
        .sorted(Comparator.comparing(p-> p.getWeight() *10000/ p.getHeight() / p.getHeight()))
        .limit(3)
        .forEach(System.out::println);
    }
    
	void readData(){
		String entry;
		double weight=0, height = 0;
		String name = "";
		try{
			BufferedReader din = new BufferedReader(new FileReader("listdata.txt"));
			while ((entry=din.readLine()) != null) {             //`ファイルから1行読む`
				Scanner sc = new Scanner(entry);                  //`値を切り出すためScannerを使う`
				if(sc.hasNext()) name = sc.next();               //`名前を取り出す(使わない)`
				if(sc.hasNextDouble()) weight = sc.nextDouble(); //`\label{S1-4} 体重を取り出す`
				if(sc.hasNextDouble())height = sc.nextDouble();  //`身長を取り出す(使わない)`
				map.put(name, new HData(name, weight, height));     
			}
			din.close();
		}catch(IOException error) { System.out.println("IOエラー発生");}
	} 
	public static void main(String[] args){
		new StreamBMI().start();
	}
	class HData{ //`\label{S4-7}データ保持用のクラス`
		String name;  double weight;  double height;  
		HData (String name, double weight, double height){
			this.name = name; this.weight = weight;  this.height = height;
		}
		@Override  public String toString(){
			return("("+ name + ":" + weight+", "+ height +")");
		}
        double getHeight(){return height;}
		double getWeight(){return weight;}
	}
}
