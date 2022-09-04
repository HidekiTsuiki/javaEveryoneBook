package chap13;
// Hello New Layout (using VBox with CSS)
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //Pane
import javafx.stage.Stage;  //Stage

public class HelloVBoxStyle extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("ボタン1");
		Button b2 = new Button("ボタン２");
		Label label = new Label("こんにちは");
	
		HBox hb = new HBox();
		hb.getChildren().add(b1); 
		hb.getChildren().add(b2); 
		hb.getStyleClass().add("hbox");
	
		VBox root = new VBox();
		root.getChildren().add(label);
		root.getChildren().add(hb);
		root.getStyleClass().add("myPane");
		Scene scene = new Scene(root);
		scene.getStylesheets().add("layout2.css");

		pstage.setTitle("New Layout 2");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
