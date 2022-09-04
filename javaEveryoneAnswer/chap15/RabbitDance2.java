package chap15;
// うさぎのダンスアニメーション　ボタン付き, 音付き
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.geometry.*;
import javafx.scene.media.AudioClip;
public class RabbitDance2 extends Application {
	@Override
	public void start(Stage stage) {
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
		stage.setTitle("Rabbit Dance");
		b2.requestFocus();  //最初，ストップボタンにフォーカスをおく（選択された状態）
		stage.setScene(scene);
		stage.sizeToScene();
        stage.show();
	
		//音声
		//AudioClipオブジェクトの生成
		AudioClip audio = 
			new AudioClip(getClass().getResource("/rabbitdance.mp3").toString());
		audio.setCycleCount(AudioClip.INDEFINITE); //繰り返し再生
	    
		//イベントハンドラの設定
		b1.setOnAction((event)-> {
			anime.timer.start();
			audio.play();
		});
		b2.setOnAction((event) -> {
			anime.timer.stop();
			audio.stop();
		});
	}

    public static void main(String... args) {
        launch(args);
    } 
}