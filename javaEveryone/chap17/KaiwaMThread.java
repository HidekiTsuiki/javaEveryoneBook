package chap17;
//カウンセラーサーバ　通信処理スレッド
import java.net.*;
import java.io.*;

public class KaiwaMThread extends Thread {
   Socket socket = null;

   public KaiwaMThread(Socket s) {
      super("KaiwaMSThread");
      socket = s;
   }

    public void run() {
      try{
         BufferedWriter out = 
	    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         BufferedReader in = 
	    new BufferedReader(new InputStreamReader(socket.getInputStream()));

         String fromC, fromUser;
         Counsel c = new Counsel();
         out.write("何でも話してください\n");
         out.flush();
         while ((fromUser = in.readLine()) != null) {
            fromC = c.kaiwa(fromUser);
            out.write(fromC + "\n");
	    out.flush();
            if (fromC.equals("ではまたにしましょう。")) break;
         }
         in.close();
         out.close();
         socket.close();
      } catch (IOException e) { 
         System.out.println("runメソッド実行中例外: " + e);
         System.exit(1);
      }
   }
}


