package chap17;
//練習問題 肥満度判定サーバ
import java.net.*;
import java.io.*;

public class HimanServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverS = null;
      Socket clientS = null;
      try{
          serverS = new ServerSocket(50001);
      } catch (IOException e) {
          System.out.println("ポートにアクセスできません。");
          System.exit(1);
      }
      System.out.println("肥満度サーバ起動");
      try{
         clientS = serverS.accept();
      } catch (IOException e) {
         System.out.println("Acceptに失敗しました。");
         System.exit(1);
      }

      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientS.getOutputStream()));
      BufferedReader in = new BufferedReader(new InputStreamReader(clientS.getInputStream()));

      String fromS, fromU;
      HimandoHantei calc = new HimandoHantei();

      out.write("肥満度を判定します。\n");
      out.write("肥満度判定サーバ: あなたの体重(Kg)を入力してください。\n");
      out.flush();
      fromU = in.readLine();  //クライアントが入力した体重を読む

      try{
         calc.w = Double.parseDouble(fromU);  //体重を設定
      } catch (NumberFormatException error){ calc.w = 0.0;}    

      out.write("肥満度判定サーバ: あなたの身長(cm)を入力してください。\n");
      out.flush();
      fromU = in.readLine();  //クライアントが入力した身長を読む
      try{
         calc.h = Double.parseDouble(fromU);  //身長を設定
      } catch (NumberFormatException error){ calc.h = 0.0;}    

      fromS = String.format("肥満度判定サーバ: あなたの標準体重は%.1f Kgで，判定の結果は%sです。", calc.calcStdWeight(), calc.judgeHiman());
      out.write(fromS);     //判定をクライアントに渡す
      out.flush();

      in.close();
      out.close();
      clientS.close();
      serverS.close();
    }
}


class HimandoHantei{
   double w, h; //体重と身長
   
   double calcStdWeight(){ //標準体重を計算
      return h/100 * h/100 * 22; 
   }

   double calcHimando(){  //肥満度を計算
      return w /((h/100)*(h/100));
   }

   String judgeHiman(){  //肥満度を判定
      double bmi = Math.round(calcHimando()*100) / 100;//計算結果を小数点2桁に四捨五入後判定
      if (bmi<16) return "痩せすぎ";
      else if (bmi<18.5) return "痩せぎみ";
      else if (bmi<25) return "普通";
      else if (bmi<30) return "太りぎみ";
      else return "肥満";
   }
}
