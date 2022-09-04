package chap13;
// ボタンにアイコンをはりつける
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //Pane
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView
 
public class HelloIcon extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("あいさつ", new ImageView("Hello.png"));
		Button b2 = new Button("消える", new ImageView("doron.png"));
		Label label = new Label("こんにちは");
		BorderPane root = new BorderPane();
		root.setTop(label);
		root.setCenter(b1);
		root.setRight(b2);

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
