package chap14;
//ComboBoxのChangeListenerによる応答
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label etc
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*; //Image, ImageView

public class ComboBoxEvent2 extends Application {
	@Override
	public void start(Stage pstage) {
		//画像準備とラベル
		Image img[] = new Image[4];  //画像データ
		img[0] = new Image("syoumen.png");
		img[1] = new Image("dance.png");
		img[2] = new Image("lay.png");
		img[3] = new Image("up.png");
		ImageView iv = new ImageView(img[0]);
		Label label = new Label("", iv);
		//コンボボックス
		ComboBox <String> cb  = new ComboBox<String>();
		cb.getItems().addAll("スクッと立つ", "ガンガン踊る", "バタッと倒れる", "ムクッと立ち上がる");
		cb.setValue(cb.getItems().get(0)); //選択項目の先頭を設定
		//コンテナに配置
		VBox root = new VBox();
		root.getChildren().addAll(label, cb);  
		//スタイル指定
		cb.getStyleClass().add("combobox");
		root.getStyleClass().add("vbox");
        Scene scene = new Scene(root);
		scene.getStylesheets().add("comboBoxEvent.css");
		pstage.setTitle("Select Icon");
		pstage.setScene(scene);
		pstage.show();
	
		//値が変化した時の処理
		cb.getSelectionModel().selectedIndexProperty().addListener(( ov, oldValue, newValue) -> {
			iv.setImage(img[cb.getSelectionModel().getSelectedIndex()]);
		});
	}
	public static void main(String[] args) {
		launch(args);
    }
}