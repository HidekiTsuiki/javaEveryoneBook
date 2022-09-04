package chap14;
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //BorderPane
import javafx.stage.Stage;  //Stage
 
public class List14_1 extends Application {
	@Override
	public void start(Stage pstage) {
	Button b1 = new Button("ごあいさつ");
		Button b2 = new Button("消去");
		Label label = new Label("　");
		BorderPane root = new BorderPane();
		root.setTop(label);
		root.setLeft(b1);
		root.setRight(b2);
		
		//イベントハンドラ
		b1.setOnAction((event)-> {  //`ラムダ式でイベント処理の内容を設定`
			label.setText("こんにちは");  //`labelに文字列を設定`
		});
		b2.setOnAction((event)-> {  //`ラムダ式でイベント処理の内容を設定`
			label.setText("　");  //`labelに文字列を設定`
		});
		Scene scene = new Scene(root);
		pstage.setTitle("Hello");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
