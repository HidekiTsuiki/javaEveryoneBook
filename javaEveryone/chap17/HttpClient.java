package chap17;
//httpクライアント
import java.io.*;
import java.net.*;

public class HttpClient {
   public static void main(String[] args) throws IOException {
      Socket soc = null;
      BufferedWriter out = null;
      BufferedReader in = null;
      String host = "www.ndl.go.jp";
      String path = "/index.html";
      soc = new Socket(host, 80);
      out = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
      in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

      out.write("GET " + path + " HTTP/1.1\r\n");
      out.write("Host: " + host + ":80\r\n");
      out.write("\r\n");
      out.flush();

      String line;
      while ((line = in.readLine()) != null) {
         System.out.println(line);
      }
      in.close();
      out.close();
      soc.close();
   }
}
