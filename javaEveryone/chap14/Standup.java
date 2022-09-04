package chap14;
// CheckBoxでのActionEvent
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView

public class Standup extends Application {
	@Override
	public void start(Stage pstage) {
		Image lay = new Image("lay.png");
		Image up = new Image("up.png");
		ImageView iv = new ImageView(lay);
		Label label = new Label("", iv);
		CheckBox cbox = new CheckBox("立つ");  //チェックボックス
		HBox root = new HBox();
		// スタイルシートを使わないで，プロパティの設定によってスタイルを指定する例
		//root.setSpacing(20);  //間隔
		//root.setPadding(new Insets(15, 10, 15, 10));  //上右下左のスペース
		//root.setAlignment(Pos.CENTER);
		root.getStyleClass().add("hbox");
		root.getChildren().addAll(label, cbox);
		Scene scene = new Scene(root);
		scene.getStylesheets().add("standup.css");
		pstage.setTitle("Stand up");
		pstage.setScene(scene);
		pstage.show();
		//イベントハンドラの設定
		cbox.setOnAction((event)-> {
			if(cbox.isSelected()) {
				iv.setImage(up);
			} else {
				iv.setImage(lay);
			}
		});
	}
	public static void main(String[] args) {
		launch(args);
    }
}
