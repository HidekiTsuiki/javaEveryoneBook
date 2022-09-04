package chap13;
// Hello New Layout (using VBox)
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //Pane
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;  //Pos
 
public class HelloNewLayout2 extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("ボタン1");
		Button b2 = new Button("ボタン２");
		Label label = new Label("こんにちは");

		HBox hb = new HBox();
		hb.getChildren().add(b1); 
		hb.getChildren().add(b2);
		hb.setAlignment(Pos.CENTER); //配置を中央に
		VBox root = new VBox();
		root.getChildren().add(label);
		root.getChildren().add(hb);

		//root.setAlignment(Pos.CENTER); //配置を中央に
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
