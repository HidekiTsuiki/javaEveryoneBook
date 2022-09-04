package chap12;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample{
	Map<String, HData> map = new HashMap<>();  //`\label{S4-1}HashMapを生成`
	void start(){
		readData();
		System.out.println(higher0(new ArrayList<>(map.values())));
		System.out.println(higher2(new ArrayList<>(map.values())));
		System.out.println(higher1(new ArrayList<>(map.values())));
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
				sc.close();
			}
			din.close();
		}catch(IOException error) { System.out.println("IOエラー発生");}
	} 

	List<String> higher0(List<HData> a){
		List<String> result = new LinkedList<String>();
		for(HData h : a){
			if(h.height >= 180){
				result.add(h.name);
			}
		}
		return result;
	}

	List<String> higher1(List<HData> a){
        List<String> result = new LinkedList<String>();
		a.removeIf((v-> v.height < 180));
		a.forEach(v-> result.add(v.name));
		return result;
	}	

	List<String> higher2(List<HData> list){
		return list.stream()
				.filter(h-> (h.height >= 180))
				.map(v -> v.name)
				.collect(Collectors.toList());
	}

	public static void main(String[] args){
		new StreamExample().start();
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
