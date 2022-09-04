package chap15;
// うさぎのダンスアニメーション　ボタン付き
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.geometry.*;

public class RabbitDance extends Application {
	@Override
	public void start(Stage pstage) {
		//下部ボタンコンテナ
		Button b1 = new Button("スタート");
		Button b2 = new Button("ストップ");
		HBox lowerPane = new HBox(); 
		lowerPane.setAlignment(Pos.CENTER);
		lowerPane.getChildren().addAll(b1, b2);
		lowerPane.setPadding(new Insets(15, 10, 15, 10));
		lowerPane.setSpacing(20);
		//上部ラベルコンテナ
		RabbitAnimationNode anime = new RabbitAnimationNode(); 
		HBox upperPane = new HBox();
		upperPane.setSpacing(20);  
		upperPane.setPadding(new Insets(15, 10, 15, 10)); 
		upperPane.getChildren().add(anime);
		upperPane.setAlignment(Pos.TOP_CENTER);

		VBox root = new VBox();
		root.getChildren().addAll(upperPane, lowerPane);
		Scene scene = new Scene(root);
		pstage.setTitle("Rabbit Dance");
		b2.requestFocus();  //最初，ストップボタンにフォーカスをおく（選択された状態）
		pstage.setScene(scene);
		pstage.sizeToScene();
        pstage.show();

		//イベントハンドラの設定
		b1.setOnAction((event)-> {
			anime.timer.start();
		});
		b2.setOnAction((event) -> {
			anime.timer.stop();
		});
	}

    public static void main(String... args) {
        launch(args);
    } 
}