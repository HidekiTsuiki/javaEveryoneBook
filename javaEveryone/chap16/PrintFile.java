package chap16;
//ファイルへ書式付き出力
import java.io.*;
public class PrintFile{
	void dataInOut() { 
		String name = "青田";  //書き出すデータ
		double weight = 60.5;
		double height = 170.6;
		try(PrintWriter fileout = new PrintWriter("list.txt", "UTF-8"); ){
			fileout.printf("%s %.1f %.1f", name, weight, height);
			//System.out.printf("%s %.1f %.1f", name, weight, height);
		}catch(IOException error) { System.out.println("IOエラー発生");}
	}
	public static void main(String[] args){
		PrintFile r = new PrintFile();
		r.dataInOut();
	}
}
