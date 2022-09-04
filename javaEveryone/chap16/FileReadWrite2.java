package chap16;
//リスト15.3 ファイルを一行ずつ読む
import java.io.*;
public class FileReadWrite2{
  void dataInOut() {   //一行ずつ読んで表示
    try (
       BufferedReader din = new BufferedReader(new FileReader("Hello.java")); )
    {
       String s;
       while((s = din.readLine()) != null){//ファイルの最後まで、1行読み
	  System.out.println(s);    //標準出力へ表示
       }
    } catch(IOException error) { System.out.println("IOエラー発生");}
  }    

  public static void main(String[] args){
      FileReadWrite2 r = new FileReadWrite2();
      r.dataInOut();
  }
}
