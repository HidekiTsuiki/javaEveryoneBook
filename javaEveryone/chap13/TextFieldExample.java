package chap13;
// LabelとTextField
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;   
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;   //Insets

public class TextFieldExample extends Application {
	@Override
	public void start(Stage pstage) {
		Label label = new Label("名前"); //文字のラベル
		TextField tf = new TextField(); //テキストフィールド生成
		HBox root = new HBox();
		root.setPadding(new Insets(15, 10, 15, 10)); 
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER); //中央揃え
		root.getChildren().addAll(label, tf);
		Scene scene = new Scene(root);
		pstage.setTitle("TextField Sample");
		pstage.setScene(scene);
		pstage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
