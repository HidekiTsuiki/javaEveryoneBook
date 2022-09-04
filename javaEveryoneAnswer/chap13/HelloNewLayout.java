package chap13;
// Hello New Layout (using FlowPane)
import javafx.application.Application;
import javafx.stage.Stage;  //Stage
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //BorderPane, FlowPane

public class HelloNewLayout extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("ボタン1");
		Button b2 = new Button("ボタン２");
		Label label = new Label("こんにちは");
		BorderPane root = new BorderPane();
		root.setTop(label);
		
		FlowPane fp = new FlowPane();
		fp.getChildren().add(b1); 
		fp.getChildren().add(b2); 
		fp.setPrefWrapLength(140);  // FlowPaneの大きさを指定
		root.setCenter(fp);

		Scene scene = new Scene(root);

		pstage.setTitle("New Layout");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
