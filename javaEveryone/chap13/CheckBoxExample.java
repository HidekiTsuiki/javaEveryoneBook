package chap13;
// CheckBox
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView
import javafx.geometry.*;   //Insets

public class CheckBoxExample extends Application {
	@Override
	public void start(Stage pstage) {
		Image image = new Image("dance.png");
		CheckBox cbox1 = new CheckBox("かめ");  //チェックボックス
		CheckBox cbox2 = new CheckBox();  //空のチェックボックス
		cbox2.setGraphic(new ImageView(image));  //グラフィックアイコンを設定
		cbox2.setSelected(true);
		VBox root = new VBox();
		root.setSpacing(20);  //ラベル間隔
		root.setPadding(new Insets(15, 10, 15, 10));  //上右下左のスペース
		root.getChildren().addAll(cbox1, cbox2);
		Scene scene = new Scene(root);
		pstage.setTitle("CheckBox Sample");
		pstage.setScene(scene);
		pstage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
