package chap16;
// csvファイルを読んで，平均を計算，ファイルに追加
import java.io.*;
import java.util.*;

public class CalcRatioAve {
	ArrayList<Integer> year = new ArrayList<Integer>();  //一行目, 年
	ArrayList<String> name = new ArrayList<String>();  //一列目, 都道府県
	ArrayList<ArrayList<Double>> ratio=new ArrayList<ArrayList <Double>>();  //県ごと年ごとの値
	String aveStr = "平均";
	void dataRead() {   //csvファイルを読む
		String s;
		try( BufferedReader din = new BufferedReader(new FileReader("birthratio.csv")); ){  
			if((s=din.readLine()) != null){  //1行目を読む
				Scanner sc = new Scanner(s);     
				sc.useDelimiter(",");
				while (sc.hasNextInt()) {  //整数値を読む
					year.add(sc.nextInt());
				}
				sc.close();
			}
			//System.out.println(year);
			while( (s=din.readLine()) != null ){  //2行目以降を読む
				Scanner sc = new Scanner(s);     
				sc.useDelimiter(",");
				String pref = null;   //都道府県名
				if(sc.hasNext()) {
					pref = sc.next();  //文字列を読む
					name.add(pref);
				}
				ArrayList<Double> row = new ArrayList<Double>(); //行のデータ 
				while (sc.hasNextDouble()) {  //実数値を読む
					row.add(sc.nextDouble());
				}
				sc.close();
				//System.out.println(pref + "  " + row);
				ratio.add(row);
			} 
		}catch(IOException error) { System.out.println("読み込みエラー発生");}
	}

	void calcAve(){
		for(int i=0; i<year.size(); i++){  //年ごとに
		    double total = 0;
			for(ArrayList<Double> row : ratio){  //行ごとの値を合計
				total = total + row.get(i);
			}
			double a = total / name.size();  // 平均を計算
			aveStr = aveStr.concat("," + String.format("%.2f", a));  //小数点以下２桁にして文字列に追加
		}
		System.out.println(aveStr);  //コンソールに表示
	}
	void dataWrite(){
		try( BufferedWriter dout =
				new BufferedWriter(new FileWriter("birthratio.csv", true)); ){
			dout.write(aveStr);
			dout.write("\n");
		}catch(IOException error) { System.out.println("書き込みエラー発生");}
	}
	public static void main(String[] args){
		CalcRatioAve r = new CalcRatioAve();
		r.dataRead();
		r.calcAve();
		r.dataWrite();
	}
}
