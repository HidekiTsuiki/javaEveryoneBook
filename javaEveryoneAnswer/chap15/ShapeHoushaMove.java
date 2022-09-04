package chap15;
import javafx.application.Application;
import javafx.stage.Stage; //Stage
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Rectangle, Line

public class ShapeHoushaMove extends Application {
    Pane root;
	double w = 250, h=250;
    double centerX, centerY;
    Line [] lines;
    @Override
    public void start(Stage pstage) {
        root = new Pane();
		root.setPrefSize(w, h);
		centerX = w/2;
        centerY = h/2;
        makeShapes();
		Scene scene = new Scene(root);
        pstage.setTitle("Shape Housha Move");
        pstage.setScene(scene);
        pstage.show();
	
        scene.setOnMouseDragged((event) -> { 
			drawShapes(event.getX(), event.getY());
		});
    }

    void makeShapes() {
        double x, y, angle;
        lines = new Line[12];
		for(int i=0; i<lines.length; i++){
	    	angle = 30*i;
            x = centerX + 100*Math.cos(Math.toRadians(angle));
            y = centerY - 100*Math.sin(Math.toRadians(angle));
	    	lines[i] = new Line(centerX, centerY, x, y);
	    	lines[i].setStrokeWidth(2);
            root.getChildren().add(lines[i]);
		}
    }
    
    void drawShapes(double mX, double mY) {
		for(int i=0; i<lines.length; i++){
            lines[i].setStartX(mX);
            lines[i].setStartY(mY);
		}
    }

    public static void main(String... args) {
        launch(args);
    }
}
