package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.stage.Stage;
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Circle
import javafx.scene.paint.*; //Color, ImagePattern
import javafx.animation.*; //Transition
import javafx.util.*;      //Duration
import javafx.scene.input.*; //MouseEvent

public class PathTransitionEvent extends Application {
	Pane root;
	Circle cir;
	double w=400, h=400;
	double radius=150;
	PathTransition trans;
	@Override
	public void start(Stage pstage) {
		root = new Pane();
		root.setPrefSize(w, h);
		Scene scene = new Scene(root);
		makeShapes();
		pstage.setTitle("Transition Example");
		pstage.setScene(scene);
		pstage.show();
		trans.play();
		cir.setOnMousePressed((MouseEvent event) -> {
			trans.setRate(-trans.getRate());// 変化の向きを反転
			trans.play();
		});
    }

	void makeShapes() {
		cir = new Circle(30, Color.RED);
		root.getChildren().add(cir);
		trans = new PathTransition();
		Circle path = new Circle(w/2, h/2, radius); // アニメーションのパス
		trans.setDuration(Duration.millis(3000));
		trans.setNode(cir);
		trans.setPath(path);  // アニメーションのパスを設定
		trans.setInterpolator(Interpolator.LINEAR);// 変化は一定速度
		trans.setCycleCount(Animation.INDEFINITE);// 無限の繰り返し
    }

	public static void main(String... args) {
		launch(args);
    }
}
