package chap14;
// 肥満度判定
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;   
import javafx.stage.Stage;  //Stage

public class Himando extends Application {
    TextField tfH, tfW;
    Label laStdW, laBMI, laJdg;
    @Override
    public void start(Stage pstage) {
		tfH = new TextField(); //身長入力域
		tfW = new TextField(); //体重入力域
		laStdW = new Label(""); //標準体重表示ラベル
		laBMI = new Label(""); //肥満度表示ラベル
		laJdg = new Label(""); //肥満度判定表示ラベル
		tfH.setPrefColumnCount(5);
		tfW.setPrefColumnCount(5);
		GridPane root = new GridPane();
		root.addRow(0, new Label("身長(cm)"), tfH);
		root.addRow(1, new Label("体重(kg)"), tfW);
		root.addRow(2, new Label("標準体重(kg)"), laStdW);
		root.addRow(3, new Label("肥満度"), laBMI);
		root.addRow(4, new Label("肥満度判定"), laJdg);
		root.getStyleClass().add("gridpane");
        Scene scene = new Scene(root);
		scene.getStylesheets().add("textfieldevent.css");
        pstage.setTitle("BMI");
        pstage.setScene(scene);
        pstage.show();
		//イベントハンドラ
		tfH.setOnAction((event)-> {
	  	  doCalc();
        });
		tfW.setOnAction((event)-> {
	   	 doCalc();
        });
    }
    public static void main(String[] args) {
        launch(args);
    }

   void doCalc(){
	   double h; //身長データ
       double w; //体重データ
       try{ //身長を設定
          h = Double.parseDouble(tfH.getText()); //double型に変換
       } catch (NumberFormatException error){ h = 0.0; }  //エラーがあれば0
       try{ //体重を設定
          w=Double.parseDouble(tfW.getText()); //double型に変換
      } catch (NumberFormatException error){ w = 0.0; }
      if(h <= 0){ tfH.requestFocus(); } //入力エラーがあった所へカーソル移動
      else if(w <= 0){ tfW.requestFocus();}
      else{
	  double std = h/100 * h/100 * 22; //標準体重を計算
	  double bmi = w /((h/100)*(h/100));  //肥満度を計算
	  bmi = Math.round(bmi*100) / 100.0;  //小数点以下2桁に
	  laStdW.setText(String.valueOf(std));//標準体重を表示
	  laBMI.setText(String.format("%.2f",bmi));  //肥満度を表示

	  if (bmi<16) laJdg.setText("痩せすぎ");
	  else if (bmi<18.5) laJdg.setText("痩せぎみ");
	  else if (bmi<25) laJdg.setText("普通");
	  else if (bmi<30) laJdg.setText("太りぎみ");
	  else laJdg.setText("肥満");
      }
   }
}
