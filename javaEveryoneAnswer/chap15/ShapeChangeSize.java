package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.stage.Stage; //Stage
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  // Circle
import javafx.scene.paint.*; //Color
import javafx.animation.*; //Transition
import javafx.util.*;      //Duration

public class ShapeChangeSize extends Application {
	Pane root;
	double w=220, h=220;
	@Override
	public void start(Stage pstage) {
		root = new Pane();
		root.setPrefSize(w, h);
		Scene scene = new Scene(root);
		makeShapes();
		pstage.setTitle("Shape Animatioin");
		pstage.setScene(scene);
		pstage.show();
	}

	void makeShapes() {
		Circle cir[][] = new Circle[10][10];
		double x,y;
		for(int i=0; i<10; i++){
			x = 20*(i+1);
			for(int j=0; j<10; j++){
				y = 20*(j+1);
				cir[i][j] = new Circle(x, y, 5);
				cir[i][j].setFill(Color.TRANSPARENT);
				cir[i][j].setStroke(Color.BLACK);
				root.getChildren().add(cir[i][j]);
				Timeline tline = new Timeline(
					new KeyFrame(Duration.seconds(0), new KeyValue(cir[i][j].radiusProperty(), 5)),
					new KeyFrame(Duration.seconds(20), new KeyValue(cir[i][j].radiusProperty(), w/2)));
				tline.setCycleCount(Animation.INDEFINITE);
				tline.setAutoReverse(true);
				tline.play();
			}
		}
	}

	public static void main(String... args) {
		launch(args);
    }
}
