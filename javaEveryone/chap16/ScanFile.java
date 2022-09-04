package chap16;
// csvファイルから読んだデータを，Scannerで解析
import java.io.*;
import java.util.*;
public class ScanFile {
	ArrayList<Integer> year = new ArrayList<Integer>();  //一行目, 年
	ArrayList<String> name = new ArrayList<String>();  //一列目, 都道府県
	ArrayList<ArrayList<Double>> ratio=new ArrayList<ArrayList <Double>>();  //県ごと年ごとの値
	void dataRead() {   //csvファイルを読む
		String s;
		try( BufferedReader din = new BufferedReader(new FileReader("birthratio.csv")); ){  
			if((s=din.readLine()) != null){  //1行目を読む
				Scanner sc = new Scanner(s);     
				sc.useDelimiter(",");
				while (sc.hasNextInt()) {  //整数値を読む
					year.add(sc.nextInt());  //年をリストに追加
				}
				sc.close();
			}
			System.out.println(year);
			while( (s=din.readLine()) != null ){  //2行目以降を読む
				Scanner sc = new Scanner(s);     
				sc.useDelimiter(",");
				String pref = null;   //都道府県名
				if(sc.hasNext()) {
					pref = sc.next();  //文字列を読む
					name.add(pref);    //文字列(都道府県名)をリストに追加
				}
				ArrayList<Double> row = new ArrayList<Double>(); //行のデータ 
				while (sc.hasNextDouble()) {  //実数値を読む
					row.add(sc.nextDouble());
				}
				sc.close();
				System.out.println(pref + "  " + row);
				ratio.add(row);      //都道府県ごとのデータをリストに追加
			}
		}catch(IOException error) { System.out.println("IOエラー発生");}
	}

	public static void main(String[] args){
		ScanFile r = new ScanFile();
		r.dataRead();
	}
}
