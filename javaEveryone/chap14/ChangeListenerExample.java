package chap14;
// ChangeListener
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;   // Pos

public class ChangeListenerExample extends Application {
	@Override
	public void start(Stage pstage) {
		Slider slider = new Slider(0, 100, 0);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setPrefWidth(200);
		Label label = new Label("0.0");
		//全体の配置
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(20, 20, 20, 20));
		root.getChildren().addAll(slider, label);
		Scene scene = new Scene(root);
		pstage.setTitle("ChangeListener");
		pstage.setScene(scene);
		pstage.show();
		//イベント処理　スライダーが変化したらラベルの値を変更
		slider.valueProperty().addListener((ov, oldValue, newValue) -> {  //リスナーの指定
			label.setText(String.valueOf(newValue.doubleValue()));
		});
	}
	public static void main(String[] args) {
		launch(args);
    }
}
