package chap17;
//カウンセラーサーバ
import java.net.*;
import java.io.*;

public class KaiwaServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverS = null;
      Socket clientS = null;
      try{ 
	 serverS = new ServerSocket(50000); 
      } catch (IOException e) {
         System.out.println("ポートにアクセスできません。");
         System.exit(1);
      }
      System.out.println("KaiwaServer起動");
      try{ 
         clientS = serverS.accept(); 
      } catch (IOException e) {
         System.out.println("Acceptに失敗しました。");
         System.exit(1);
      }
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientS.getOutputStream()));
      BufferedReader in = new BufferedReader(new InputStreamReader(clientS.getInputStream()));
      String fromC, fromUser;
      Counsel c = new Counsel();
      out.write("何でも話してください。\n");
      out.flush();
      while ((fromUser = in.readLine()) != null) {
         fromC = c.kaiwa(fromUser);
         out.write(fromC + "\n");
	     out.flush();
         if (fromC.equals("ではまたにしましょう。")) break;
      }
      in.close();  out.close();
      clientS.close();  serverS.close();
    }
}

class Counsel{
   int i, n=0;
   String[] henji = { 
       "興味がありますね。", 
       "ほう、そうですか。", 
       "もっと聞かせてください。",
       "なるほど。", 
       "それで?"};
   String kaiwa(String user){
      i = (int)(Math.random()* henji.length);
      n++;
      if(n>10) return  "ではまたにしましょう。";
      else if(i==0) return (user + "とは" + henji[i]);
      else return henji[i];
   }
}
