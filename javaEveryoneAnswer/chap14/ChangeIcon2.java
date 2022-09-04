package chap14;
// 練習問題　CheckBoxでのActionEvent
import javafx.application.Application;
import javafx.event.*;  //ActionEvent
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView

public class ChangeIcon2 extends Application {
	@Override
	public void start(Stage pstage) {
		//画像の設定
		Image frog = new Image("frog.png");//アイコンオブジェクトの生成 
		Image bug = new Image("bug.png");
		Image frogbug = new Image("frogbug.png");
		Image muji = new Image("muji.png");
		ImageView iv = new ImageView(muji);
		Label label = new Label("", iv);
		iv.setFitWidth(100);
		iv.setPreserveRatio(true);
		//右側
		CheckBox cbox1 = new CheckBox("カエル");  //チェックボックス
		CheckBox cbox2 = new CheckBox("虫");  //チェックボックス
		VBox rightPane = new VBox();
		rightPane.getChildren().addAll(cbox1, cbox2);
		rightPane.getStyleClass().add("vbox");
		//全体の配置
		HBox root = new HBox();
		root.getStyleClass().add("hbox");
		root.getChildren().addAll(label, rightPane);
	
		Scene scene = new Scene(root);
		scene.getStylesheets().add("changeIcon2.css");
		pstage.setTitle("Frog and bug");
		pstage.setScene(scene);
		pstage.show();

		//イベントハンドラの設定
		EventHandler<ActionEvent> h = (event)-> {
	   		if(cbox1.isSelected() && cbox2.isSelected()){ //両方チェック
	    		iv.setImage(frogbug);  
			}else if(cbox1.isSelected() && !cbox2.isSelected()){ //frogだけチェック
				iv.setImage(frog);      
			}else if(!cbox1.isSelected() && cbox2.isSelected()){ //bugだけチェック
				iv.setImage(bug);      
			}else{
				iv.setImage(muji);
			}
		};
		cbox1.setOnAction(h);
		cbox2.setOnAction(h);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
