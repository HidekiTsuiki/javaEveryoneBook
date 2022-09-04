package chap14;
// ChangeListener
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.geometry.*;   // Pos
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.beans.binding.*; //Bindings
import javafx.util.converter.*; //NumberStringConverter

public class HSBColorMaker2 extends Application {
Slider hueS;  //色相用スライダ
Slider saturationS;  //彩度用スライダ
Slider brightS;   //明度用スライダ
Rectangle rect;
	@Override
	public void start(Stage pstage) {
		hueS = new Slider(0, 360, 0);
		saturationS = new Slider(0, 100, 0);
		brightS = new Slider(0, 100, 0);
		TextField hueTf = new TextField("0");
		TextField saturationTf = new TextField("0");
		TextField brightTf = new TextField("0");
		setSliderAndTextField(hueS, hueTf, 90);
		setSliderAndTextField(saturationS, saturationTf, 20);
		setSliderAndTextField(brightS, brightTf, 20);

		//全体の配置
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.addRow(0, new Label("色相(°)"), hueS, hueTf);
		grid.addRow(1, new Label("彩度(%)"), saturationS, saturationTf);
		grid.addRow(2, new Label("明度(%)"), brightS, brightTf);
	
		rect = new Rectangle(100, 100);
		HBox root = new HBox(20);
		root.getChildren().addAll(rect, grid);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(20, 20, 20, 20));
		Scene scene = new Scene(root);
        pstage.setTitle("HSB Color Maker");
        pstage.setScene(scene);
        pstage.show();
		
		//四角形の塗りをバインディングで変える
		rect.fillProperty().bind(Bindings.createObjectBinding(
			() -> { return Color.hsb(hueS.getValue(), saturationS.getValue()/100, brightS.getValue()/100); }, 
			hueS.valueProperty(), saturationS.valueProperty(), brightS.valueProperty() ));
	}
	//スライダとテキストフィールドの設定メソッド (スライダ，テキストフィールド，スライダの目盛り間隔)
	void setSliderAndTextField(Slider slider, TextField tf, double tickUnit){
		slider.setPrefWidth(300);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(tickUnit);
		//tf.setPrefWidth(70);
		tf.setPrefColumnCount(5);
		
		//スライダーとテキストフィールドの双方向のバインディング
		tf.textProperty().bindBidirectional(slider.valueProperty(), 
											new NumberStringConverter("#.##"));
    }

	public static void main(String[] args) {
		launch(args);
	}
}
