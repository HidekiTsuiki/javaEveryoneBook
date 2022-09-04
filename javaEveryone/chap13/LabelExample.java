package chap13;
// Label
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;   
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView
import javafx.geometry.*;   //Insets

public class LabelExample extends Application {
	@Override
	public void start(Stage pstage) {
		Label a1 = new Label("うさぎ"); //文字のラベル
		Image image = new Image("dance.png");
		Label a2 = new Label("ダンス", new ImageView(image));  //文字とアイコンのラベル
		a2.setContentDisplay(ContentDisplay.TOP); //アイコンを上に
		HBox root = new HBox();
		root.setSpacing(20);  //ラベル間隔
		root.setPadding(new Insets(15, 10, 15, 10));  //上右下左のスペース
		root.getChildren().addAll(a1, a2);
		Scene scene = new Scene(root);
		pstage.setTitle("Label Sample");
		pstage.setScene(scene);
		pstage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
