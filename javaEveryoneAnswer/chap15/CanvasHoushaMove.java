package chap15;
import javafx.application.Application;
import javafx.stage.Stage; //Stage
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  //Pane
import javafx.scene.canvas.*;  //Canvas, GraphicsContext


public class CanvasHoushaMove extends Application {
	Canvas canvas;
	double centerX, centerY;
	@Override
	public void start(Stage pstage) {
		Pane root = new Pane();
		canvas = new Canvas(250, 250);
		root.getChildren().add(canvas);
	
		Scene scene = new Scene(root);
		centerX = canvas.getWidth()/2;
		centerY = canvas.getHeight()/2;
	
		drawCanvas(centerX, centerY);
		pstage.setTitle("Canvas Housha Move");
        pstage.setScene(scene);
        pstage.show();
	
		scene.setOnMouseDragged((event) -> {
			drawCanvas(event.getX(), event.getY());
		});
    }

	void drawCanvas(double cX, double cY) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		double x, y, angle;
		double len = 100;
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.setLineWidth(2);
		for(int i=0; i<12; i++){
			angle = 30*i;
			x = centerX + len*Math.cos(Math.toRadians(angle));
			y = centerY - len*Math.sin(Math.toRadians(angle));
			gc.strokeLine(cX, cY, x, y);
		}
    }

	public static void main(String... args) {
		launch(args);
    }
}
