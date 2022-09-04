package chap14;
// 練習問題
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;
import javafx.scene.image.*;    //Image, ImageView

public class ChangeIcon extends Application {
	@Override
	public void start(Stage pstage) {
		//下部ボタンコンテナ
		Button b1 = new Button("踊る");
		Button b2 = new Button("倒れる");
		Button b3 = new Button("立つ");
		HBox lowerPane = new HBox(); 
		lowerPane.setAlignment(Pos.CENTER);
		lowerPane.getChildren().addAll(b1, b2, b3);
		lowerPane.setPadding(new Insets(15, 10, 15, 10));
		lowerPane.setSpacing(20);
		//画像準備
		Image dance = new Image("dance.png");
		Image lay = new Image("lay.png");
        Image stand = new Image("up.png");
		//上部ラベルコンテナ
		ImageView icon = new ImageView(dance);  //Labelに置くImageViewを用意
		Label label = new Label("", icon); 
		label.setContentDisplay(ContentDisplay.TOP); 
		HBox upperPane = new HBox();
		upperPane.setPadding(new Insets(15, 10, 15, 10)); 
		upperPane.getChildren().add(label);
		upperPane.setPrefSize(200, 200);
		upperPane.setAlignment(Pos.TOP_CENTER);
		//上下に配置
		VBox root = new VBox();
		root.getChildren().addAll(upperPane, lowerPane);
		//アクションイベント処理
		b1.setOnAction((event)-> {
			icon.setImage(dance);
		});
		b2.setOnAction((event) -> {
			icon.setImage(lay);
        });
		b3.setOnAction((event) -> {
			icon.setImage(stand);
		});
        Scene scene = new Scene(root);
		pstage.setTitle("Change Icon");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	}
	public static void main(String[] args) {
		launch(args);
    }
}
