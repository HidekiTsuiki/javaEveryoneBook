package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.stage.Stage;
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Circle
import javafx.scene.paint.*; //Color
import javafx.animation.*; //Transition
import javafx.util.*;      //Duration

public class TimelineExample extends Application {
	Pane root;
	Circle cir;
    double w=400, h=400;
    @Override
    public void start(Stage pstage) {
		root = new Pane();
		root.setPrefSize(w, h);
        Scene scene = new Scene(root);
        makeShapes();
        pstage.setTitle("Timeline Example");
        pstage.setScene(scene);
        pstage.show();
    }
	
	void makeShapes() {
		cir = new Circle(w/2, h/2, 5);
		root.getChildren().add(cir);
		Timeline tline = new Timeline(  //3つのキーフレームを設定
			new KeyFrame(Duration.seconds(0), new KeyValue(cir.radiusProperty(), 5),
						new KeyValue(cir.fillProperty(), Color.WHITE)),
			new KeyFrame(Duration.seconds(1), //１秒後のフレーム，塗りを黄色
						new KeyValue(cir.fillProperty(), Color.YELLOW)),
			new KeyFrame(Duration.seconds(2), //2秒後のフレーム，塗りを赤，半径w/2(200)
						new KeyValue(cir.radiusProperty(), w/2, Interpolator.EASE_IN),
						new KeyValue(cir.fillProperty(), Color.RED))
		);
		tline.setCycleCount(Animation.INDEFINITE);
		tline.setAutoReverse(true);
		tline.play();
    }

    public static void main(String... args) {
        launch(args);
    }    
}
