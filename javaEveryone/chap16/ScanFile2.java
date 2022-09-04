package chap16;
//ファイルから読んだデータを，パターンを使って解析
import java.io.*;
import java.util.*;
public class ScanFile2 {
	void dataRead() {   //パターンで読む
		try( Scanner s = 
			new Scanner(new BufferedReader(new FileReader("listdata.txt"))); )
		{
			String str;
			String p = "(\\S+)(\\s)(\\d+).(\\d+)(\\s)(\\d+).(\\d+)"; //正規表現を表す文字列
			while( (str = s.findInLine(p)) != null){  //行内にパターンを見つけて読む
				System.out.println(str);
				s.skip("(\\s+)");  //行末記号を読み飛ばす
			}
		}catch(IOException error) { System.out.println("IOエラー発生");}
		}

	public static void main(String[] args){
		ScanFile2 r = new ScanFile2();
		r.dataRead();
	}
}
