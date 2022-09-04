package chap13;
// Haiti Rensyuu
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;
import javafx.scene.image.*;    //Image, ImageView

public class HaitiRensyu extends Application {
	@Override
	public void start(Stage pstage) {
		//下部ボタンコンテナ
		Button b1 = new Button("ボタン1");
		Button b2 = new Button("ボタン2");
		Button b3 = new Button("ボタン3");
		HBox lowerPane = new HBox(); 
		lowerPane.setAlignment(Pos.CENTER);
		lowerPane.getChildren().addAll(b1, b2, b3);
		lowerPane.setPadding(new Insets(15, 10, 15, 10));
		lowerPane.setSpacing(20);  
		//上部ラベルコンテナ
		Label a1 = new Label("うさぎ"); 
		Image image = new Image("dance.png");
		Label a2 = new Label("ダンス", new ImageView(image));
		a2.setContentDisplay(ContentDisplay.TOP); 
		HBox upperPane = new HBox();
		upperPane.setSpacing(20);  
		upperPane.setPadding(new Insets(15, 10, 15, 10)); 
		upperPane.getChildren().addAll(a1, a2);
		upperPane.setPrefSize(200, 200);
		upperPane.setAlignment(Pos.TOP_CENTER);
	
		VBox root = new VBox();
		root.getChildren().addAll(upperPane, lowerPane);
		Scene scene = new Scene(root);
		pstage.setTitle("Haiti Rensyu");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
