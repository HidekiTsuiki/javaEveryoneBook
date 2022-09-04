package chap15;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  //Pane
import javafx.scene.canvas.*;  //Canvas, GraphicsContext


public class MinimalRect extends Application {
	Canvas canvas;
    int WW = 400, WH = 400;
	int X = 50, Y = 100, W = 300, H = 200, N = 6;
	@Override
    public void start(Stage pstage) {
        Pane root = new Pane();
        canvas = new Canvas(WW, WH);
		root.getChildren().add(canvas);
        drawCanvas();
        Scene scene = new Scene(root);
        pstage.setTitle("Minimal Art by Rectangle");
        pstage.setScene(scene);
        pstage.show();
    }
    
    void drawCanvas() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//gc.setLineWidth(3);
		gc.strokeRect(X, Y, W, H);
		rects(gc, X, Y, W, H, N);
    }

   void rects(GraphicsContext g, int x, int y, int w, int h, int depth){
		if(depth <= 0) return;
		if (w > h){
			int m = (int)(Math.random() * w);
			g.strokeLine(x + m, y, x + m, y+h);
			rects(g, x , y, m, h, depth-1);
			rects(g, x + m, y, w - m, h, depth-1);
		}else{
	 		int m = (int)(Math.random() * h);
		 	g.strokeLine(x, y + m, x+w, y + m);
		 	rects(g, x , y, w, m, depth-1);
			rects(g, x, y+m, w, h-m, depth-1);
		}
   }
   
    public static void main(String... args) {
        launch(args);
    }    
}
