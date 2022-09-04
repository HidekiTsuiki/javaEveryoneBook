package chap13;
// Label
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;
import javafx.scene.image.*;     //Image, ImageView
import javafx.geometry.*;       //Insets

public class TwoLabels extends HBox {
	public TwoLabels() {
		Label a1 = new Label("うさぎ"); //文字のラベル
		Image image = new Image("dance.png");
		Label a2 = new Label("ダンス", new ImageView(image));  //文字とアイコンのラベル
		a2.setContentDisplay(ContentDisplay.TOP); //アイコンを上に
		setSpacing(20);  //ラベル間隔
		setPadding(new Insets(15, 10, 15, 10));  //上右下左のスペース
		getChildren().addAll(a1, a2);
	}
}
