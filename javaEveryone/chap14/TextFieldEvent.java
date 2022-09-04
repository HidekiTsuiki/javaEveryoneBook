package chap14;
// LabelとTextField
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;   
import javafx.stage.Stage;  //Stage

public class TextFieldEvent extends Application {
	TextField tfH;
	Label laStdW;
	@Override
	public void start(Stage pstage) {
		tfH = new TextField(); //テキストフィールド生成
		laStdW = new Label(""); //計算結果表示ラベル
		GridPane root = new GridPane();
		root.addRow(0, new Label("身長(cm)"), tfH);
		root.addRow(1, new Label("標準体重(kg)"), laStdW);
		root.getStyleClass().add("gridpane");
		Scene scene = new Scene(root);
		scene.getStylesheets().add("textfieldevent.css");
        pstage.setTitle("Standard Weight");
        pstage.setScene(scene);
		pstage.show();
		//イベントハンドラ
		tfH.setOnAction((event)-> {
		    doCalc();
		});
    }

	void doCalc(){
		double h; //身長データ
		try{ //身長データを取得
			h = Double.parseDouble(tfH.getText()); //double型に変換
		} catch (NumberFormatException error){ h = 0.0; } 
		if(h > 0){
			double std = h/100 * h/100 * 22;//標準体重を計算
			laStdW.setText(String.format("%.2f", std));//標準体重を表示
		}
	}
	
	public static void main(String[] args) {
		launch(args);
    }
    
}
