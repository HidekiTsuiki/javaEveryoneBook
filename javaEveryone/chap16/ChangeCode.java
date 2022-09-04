package chap16;
//文字コードの変換
import java.io.*;
public class ChangeCode {
	void dataInOut(){ 
		int c;
		try (InputStreamReader filein = new InputStreamReader(
				new FileInputStream("Text.txt"), "SJIS"); //入力ストリーム
			OutputStreamWriter fileout = new OutputStreamWriter(
				new FileOutputStream("Back.txt"), "UTF8"); ) //出力ストリーム
		{
			while((c = filein.read()) != -1) {//ファイルの最後まで1文字読み、
				fileout.write(c);	   //それを書き出す
			}
		}catch(IOException error) { System.out.println("IOエラー発生");}
	}
	public static void main(String[] args){
		ChangeCode r = new ChangeCode();
		r.dataInOut();   
	}
}



