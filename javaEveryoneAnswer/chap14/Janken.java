package chap14;
// 練習問題
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;
import javafx.scene.image.*;    //Image, ImageView

public class Janken extends Application {
	Label labelWin;
	ImageView ivC, ivH;
	Image img[] = new Image[3];  //画像データ
	@Override
	public void start(Stage pstage) {
	//画像準備
		img[0] = new Image("gu.png");
		img[1] = new Image("tyoki.png");
		img[2] = new Image("pa.png");
		ivC = new ImageView(img[0]);
		ivH = new ImageView(img[0]);
		// 左ラベルコンテナ
		Label labelC = new Label("コンピュータ", ivC);
		Label labelH = new Label("あなた", ivH);
		Label labelVS = new Label("VS");
		HBox leftPane = new HBox();
		leftPane.getChildren().addAll(labelC, labelVS, labelH);
		leftPane.getStyleClass().add("leftPane");
		//勝敗
		labelWin = new Label(" 勝敗 ");
		//右ボタンコンテナ
        Button b1 = new Button("グー");
		Button b2 = new Button("チョキ");
		Button b3 = new Button("パー");
		VBox rightPane = new VBox(); 
		rightPane.setAlignment(Pos.CENTER);
		rightPane.getChildren().addAll(b1, b2, b3);
		rightPane.getStyleClass().add("rightPane");
		//全体配置
		GridPane root = new GridPane();
		root.addRow(0, leftPane, rightPane);
		root.add(labelWin, 0, 1);
		Scene scene = new Scene(root);
		scene.getStylesheets().add("janken.css");
		pstage.setTitle("Janken");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
		//アクションイベント処理
		b1.setOnAction((event)-> {
	  		judgeWin(0);
		});
		b2.setOnAction((event) -> {
			judgeWin(1);
		});
		b3.setOnAction((event) -> {
			judgeWin(2);
		});
	}

	void judgeWin(int human){
		ivH.setImage(img[human]); //人の手を表示 
		int comp = (int)(Math.random()*3); //乱数を生成
		ivC.setImage(img[comp]); //コンピュータの手を表示 
		labelWin.setText(dispWin(comp, human)); //勝敗を表示 
	}

	String dispWin(int c, int m){  //勝敗を判定、表示
		String str = " ";
		switch(c){
		case 0: if(m==0) str = "あいこ";
			else if (m==1) str= "あなたの負け";
			else if (m==2) str= "あなたの勝ち";
			break;
		case 1: if(m==0) str = "あなたの勝ち";
			else if (m==1) str= "あいこ";
			else if (m==2) str= "あなたの負け";
			break;
		case 2: if(m==0) str = "あなたの負け";
			else if (m==1) str= "あなたの勝ち";
			else if (m==2) str= "あいこ";
			break;
		default: str = "不明";
		}
		return str;
	}

/*
//勝敗を判定する計算式を使えば，スマートに書ける
	String dispWin(int c, int m){  //勝敗を判定、表示
		switch((m - c + 3) % 3){
		case 0: return "あいこ";        // m と c が同じ
		case 1: return "あなたの負け";   // m が c の次の手
		case 2: return "あなたの勝ち";   // m が c の前の手
		default: return "不明";
		}
	}
*/
		public static void main(String[] args) {
		launch(args);
	}
}
