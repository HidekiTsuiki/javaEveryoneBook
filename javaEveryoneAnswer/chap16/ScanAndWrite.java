package chap16;
// 練習問題  データファイルを読み、計算，csvファイルへ出力
import java.io.*;
import java.util.*;

public class ScanAndWrite{
	void dataReadWrite(){ //ファイルを読み、データを解析、計算
		String entry, name="";
		double w=0, h=0;
		String str;
		try(BufferedReader din = new BufferedReader(new FileReader("listdata.txt")); 
			BufferedOutputStream fileout = 
				new BufferedOutputStream(new FileOutputStream("healthdata.csv")); 
		){
			str = "名前, 体重, 身長, BMI, 判定";  //列タイトル
			fileout.write(str.getBytes("SJIS"));
			fileout.write(System.getProperty("line.separator").getBytes("UTF8"));
			while ((entry=din.readLine()) != null) { //1行読む
				Scanner sc = new Scanner(entry);
				if(sc.hasNext()) name = sc.next();
				if(sc.hasNextDouble()) w = sc.nextDouble();
				if(sc.hasNextDouble()) h = sc.nextDouble();
				double bmi = w /((h/100)*(h/100));  //肥満度を計算
				str = String.format("%s,%.1f,%.1f,%.1f,%s", name, w, h, bmi, judgeBMI(bmi));
				sc.close();
				//System.out.println(str);
				fileout.write(str.getBytes("SJIS"));
				fileout.write(System.getProperty("line.separator").getBytes("UTF8"));
			}
		} catch(IOException error) { System.out.println("IOエラー発生");}
	}

	String judgeBMI(double bmi){
		double bmi2 = Math.round(bmi*100) / 100.0; //小数点2桁に四捨五入後判定
		if (bmi2<16) return "痩せすぎ";
		else if (bmi2<18.5) return "痩せぎみ";
		else if (bmi2<25) return "普通";
		else if (bmi2<30) return "太りぎみ";
		else return "肥満";
	}

	public static void main(String[] args){
		ScanAndWrite r = new ScanAndWrite();
		r.dataReadWrite();   
	}
}
