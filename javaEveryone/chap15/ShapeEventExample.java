package chap15;
import javafx.application.Application;
import javafx.stage.Stage; //Stage
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Rectangle, Line, Circle
import javafx.scene.image.*; //Image
import javafx.scene.paint.*; //ImagePattern

public class ShapeEventExample extends Application {
	Pane root;
	@Override
	public void start(Stage pstage) {
		root = new Pane();
		root.setPrefSize(200, 200);
		makeShapes();
		Scene scene = new Scene(root);
		pstage.setTitle("Shape Event");
		pstage.setScene(scene);
		pstage.show();
	}

	void makeShapes() {
		ImagePattern ip = new ImagePattern(new Image("goldfish.jpg"));
		ImagePattern ip2 = new ImagePattern(new Image("nofish.jpg"));
		Circle cir = new Circle(100, 100, 75, ip2);
		root.getChildren().add(cir);
		cir.setOnMouseClicked((event) -> { 
			if(cir.getFill() == ip) { cir.setFill(ip2); }
			else if(cir.getFill() == ip2) { cir.setFill(ip); }
		});
	}

	public static void main(String... args) {
		launch(args);
	}
}
