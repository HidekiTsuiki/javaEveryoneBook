package chap16;
//文字コードと改行コードの変更
import java.io.*;
public class ChangeCodeLine{

	void dataInOut(){ 
		String line;
		try (BufferedReader filein = 
				new BufferedReader(new InputStreamReader(new FileInputStream("Text.txt"), "SJIS"));
			BufferedOutputStream fileout = 
				new BufferedOutputStream(new FileOutputStream("Back.txt")); ) //出力ストリーム
		{
			while((line = filein.readLine()) != null){  //ファイルの最後まで、1行読み
				fileout.write(line.getBytes("UTF8"));
				fileout.write(System.getProperty("line.separator").getBytes("UTF8"));
			}
			fileout.flush();
		} catch(IOException error) { System.out.println("IOエラー発生");}
	}

	public static void main(String[] args){
		ChangeCodeLine r = new ChangeCodeLine();
		r.dataInOut();   
	}
}
