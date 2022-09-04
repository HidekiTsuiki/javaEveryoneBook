package chap13;
// FlowPane
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   
import javafx.stage.Stage;  //Stage
 
public class HelloFlowPane extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("ボタン1");
		Button b2 = new Button("ボタン２");
		Label label = new Label("こんにちは");
		FlowPane root = new FlowPane();  //幅400(デフォルト)，間隔0の横フローペイン
		root.getChildren().add(label);   //子のリストList<E>を取得し，ノードを追加
		root.getChildren().add(b1);
		root.getChildren().add(b2);
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
