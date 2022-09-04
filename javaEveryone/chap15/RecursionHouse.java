package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.stage.Stage;
import javafx.scene.layout.*;  //Pane

public class RecursionHouse extends Application {
    final double W = 650, H = 700;
    @Override
    public void start(Stage pstage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(W, H);
		root.getChildren().add(canvas);
        drawCanvas(canvas.getGraphicsContext2D());
        Scene scene = new Scene(root);
        pstage.setTitle("Recursion House");
        pstage.setScene(scene);
        pstage.show();
    }
    
    void drawCanvas(GraphicsContext gc) {
		drawHouse(gc, 100, 300, 128, 1);
		drawHouse(gc, 100, 600, 128, 4);
    }
    void drawHouse(GraphicsContext gc, double x, double y, double s, int n){
        drawFrame(gc, x, y, s);
        if(n <= 1){
	 		gc.strokeRect(x+s/2, y-s*7/10 , s, s/2);
		}else{
			drawHouse(gc, x+s/2, y-s/5, s/2, n-1);
		}
    }
    void drawFrame(GraphicsContext gc, double x, double y, double s){ 
		gc.strokeRect(x, y-s, s*2, s);
		gc.strokePolygon(new double[]{x-s/2, x , x+s*2, x+s*5/2},
						new double[]{y-s, y-s*3/2, y-s*3/2, y-s}, 4);
   }
    public static void main(String... args) {
        launch(args);
    }    
}
