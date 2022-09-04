package chap17;
//カウンセラークライアント
import java.io.*;
import java.net.*;

public class KaiwaClient {
   public static void main(String[] args) throws IOException {
   Socket kaiwaS = null;
   BufferedReader in = null;
   BufferedWriter out = null;
   try{
      kaiwaS = new Socket(InetAddress.getLocalHost(), 50000);
      in = new BufferedReader(new InputStreamReader(kaiwaS.getInputStream()));
      out = new BufferedWriter(new OutputStreamWriter(kaiwaS.getOutputStream()));
      } catch (UnknownHostException e) {
         System.out.println("ホストに接続できません。");
         System.exit(1);
      } catch (IOException e) {
         System.out.println("IOコネクションを得られません。");
         System.exit(1);
      }

    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String fromServer;
    String fromUser;
    while ((fromServer = in.readLine()) != null) {
       System.out.println("カウンセラー: " + fromServer);
       if (fromServer.equals("ではまたにしましょう。"))break;
       System.out.print("あなた: ");
       fromUser = stdIn.readLine();
       out.write(fromUser + "\n");
       out.flush();
    }
 
    out.close();  in.close();
    stdIn.close();  kaiwaS.close();
    }
}


