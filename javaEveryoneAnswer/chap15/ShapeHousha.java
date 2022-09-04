package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Rectangle, Line
import javafx.stage.Stage; //Stage

public class ShapeHousha extends Application {
    Pane root;
	double w = 250, h=250;
	double centerX, centerY;
	        
	@Override
	public void start(Stage pstage) {
		root = new Pane();
		root.setPrefSize(w, h);
		centerX = w/2;
		centerY = h/2;
		makeShapes();
		Scene scene = new Scene(root);
		pstage.setTitle("Shape Housha");
		pstage.setScene(scene);
		pstage.show();
	}

	void makeShapes() {
		double x, y, angle;
		Line [] lines = new Line[12];
		for(int i=0; i<lines.length; i++){
	   		angle = 30*i;
			x = centerX + 100*Math.cos(Math.toRadians(angle));
			y = centerY - 100*Math.sin(Math.toRadians(angle));
			lines[i] = new Line(centerX, centerY, x, y);
			lines[i].setStrokeWidth(2);
			root.getChildren().add(lines[i]);
		}
	}

	public static void main(String... args) {
		launch(args);
	}
}
