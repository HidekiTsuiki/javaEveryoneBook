package chap13;
// RadioButton
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;   //Insets

public class RadioButtonExample extends Application {
	@Override
	public void start(Stage pstage) {
		RadioButton rb1 = new RadioButton("立つ");  //ラジオボタン
		RadioButton rb2 = new RadioButton("踊る");   //ラジオボタン
		RadioButton rb3 = new RadioButton("倒れる");   //ラジオボタン
		ToggleGroup group = new ToggleGroup(); //トグルグループ生成
		rb1.setToggleGroup(group);  //トグルグループへラジオボタンを入れる
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		rb1.setSelected(true);  //先頭のラジオボタンを選択状態にする
		VBox root = new VBox();
		root.setSpacing(20);  //ラベル間隔
		root.setPadding(new Insets(15, 10, 15, 10));  //上右下左のスペース
		root.getChildren().addAll(rb1, rb2, rb3);  //ラジオボタンをコンテナに配置
		Scene scene = new Scene(root);
		pstage.setTitle("RadioButton Sample");
		pstage.setScene(scene);
		pstage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
