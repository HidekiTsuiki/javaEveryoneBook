package chap13;
// Hello New Layout (using VBox)
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //Pane
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;  //Pos
 
public class HelloNewLayout22 extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("ボタン1");
		Button b2 = new Button("ボタン２");
		Label label = new Label("こんにちは");
		b1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);   // 最大幅高さを設定
		b2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		HBox hb = new HBox();
		hb.getChildren().add(b1); 
		hb.getChildren().add(b2);
		HBox.setHgrow(b1, Priority.ALWAYS);  //子ノードを広げる
		HBox.setHgrow(b2, Priority.ALWAYS);
		hb.setAlignment(Pos.CENTER); //配置を中央に
		
		VBox root = new VBox();
		root.getChildren().add(label);
		root.getChildren().add(hb);

		VBox.setVgrow(label, Priority.ALWAYS);  //子ノードを広げる
		VBox.setVgrow(hb, Priority.ALWAYS);
		root.setAlignment(Pos.CENTER); //配置を中央に
		Scene scene = new Scene(root);

		pstage.setTitle("New Layout 2");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
