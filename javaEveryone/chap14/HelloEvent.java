package chap14;
import javafx.application.Application;
import javafx.stage.Stage;  //Stage
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //BorderPane
 
public class HelloEvent extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("ごあいさつ");
		Button b2 = new Button("消去");
		Label label = new Label("　");
		BorderPane root = new BorderPane();
		root.setTop(label);
		root.setLeft(b1);
		root.setRight(b2);
		Scene scene = new Scene(root);
		pstage.setTitle("Hello");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
		//イベントハンドラの設定
		b1.setOnAction((event)-> {
			label.setText("こんにちは");
		});
		b2.setOnAction((event) -> {
			label.setText("　");
        });
	}
	public static void main(String[] args) {
		launch(args);
	}
}
