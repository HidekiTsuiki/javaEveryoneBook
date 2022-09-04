package chap16;
//キーボードから読む
import java.io.*;
public class FileReadWrite3{
	void dataInOut(){   //キーボードからの入力を表示
		try(BufferedReader din = new BufferedReader(new InputStreamReader(System.in)); )
		{
			String s;
			while((s = din.readLine()) != null){//1行読み
				System.out.println(s);    //標準出力へ表示
			}
		}catch(IOException error) { System.out.println("IOエラー発生");}
	}

	public static void main(String[] args){
		FileReadWrite3 r = new FileReadWrite3();
		r.dataInOut();
	}
}
