package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene, Group
import javafx.stage.Stage; //Stage
import javafx.scene.layout.*;  //Pane
import javafx.scene.shape.*;  //Rectangle, Line, Circle
import javafx.scene.image.*; //Image
import javafx.scene.paint.*; //Color, ImagePattern

public class ShapeExample extends Application {
	Pane root;
	@Override
	public void start(Stage pstage) {
		root = new Pane();
		root.setPrefSize(250, 400);
		makeShapes();
		Scene scene = new Scene(root);
		pstage.setTitle("Shape Example");
		pstage.setScene(scene);
		pstage.show();
    }

    void makeShapes() {
		Rectangle rect = new Rectangle(50, 50, 150, 150);
		Line line1 = new Line(200, 50, 50, 200);
		Line line2 = new Line(50, 50, 200, 200);
		ImagePattern ip = new ImagePattern(new Image("goldfish.jpg"));
		Circle cir = new Circle(125, 300, 75, ip);
		rect.setStrokeWidth(3);
		rect.setStroke(Color.RED);
		rect.setFill(Color.TRANSPARENT);
		line1.setStrokeWidth(3);
		line2.setStrokeWidth(3);
		line1.setStroke(Color.RED);
		line2.setStroke(Color.RED);
		root.getChildren().addAll(rect, line1, line2, cir);
	}

	public static void main(String... args) {
		launch(args);
	}
}
