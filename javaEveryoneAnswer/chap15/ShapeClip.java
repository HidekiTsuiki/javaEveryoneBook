package chap15;

import javafx.application.Application;
import javafx.stage.Stage; //Stage
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Rectangle, Line, Circle
import javafx.scene.image.*; //Image

public class ShapeClip extends Application {
    Pane root;
	Circle cir;
    double w = 400, h = 400;
    @Override
    public void start(Stage pstage) {
        root = new Pane();
		root.setPrefSize(w, h);
        makeShapes();
		Scene scene = new Scene(root);
        pstage.setTitle("Shape Clip");
        pstage.setScene(scene);
        pstage.show();
	
		scene.setOnMouseMoved((event) -> { 
			cir.setCenterX(event.getX());
			cir.setCenterY(event.getY());
		});
	
		scene.setOnMouseExited((event) -> { 
			cir.setCenterX(-100);
			cir.setCenterY(-100);
		});
    }

    void makeShapes() {
		ImageView ivSea = new ImageView(new Image("noTurtle.png"));
		ImageView ivT = new ImageView(new Image("seaTurtle.png"));
		ivSea.setFitWidth(w);
        ivSea.setPreserveRatio(true);
		ivT.setFitWidth(w);
        ivT.setPreserveRatio(true);
	
		cir = new Circle(-100, -100, 100);
		ivT.setClip(cir);
		root.getChildren().add(ivSea);
		root.getChildren().add(ivT);
    	}

    public static void main(String... args) {
        launch(args);
    }
}
