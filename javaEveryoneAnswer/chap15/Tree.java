package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.stage.Stage;
import javafx.scene.layout.*;  // Pane
import javafx.scene.paint.*;  //Color

public class Tree extends Application {
	Canvas canvas;
	final double W = 400, H = 400;
	double scale = 0.7;  //　枝の短くなる比率
	double angle = 30; //枝の広がり
	double len = 110;  //最初の枝の長さ
	int N = 8; //枝別れの段数
	@Override
	public void start(Stage pstage) {
		Pane root = new Pane();
		canvas = new Canvas(W, H);
		root.getChildren().add(canvas);
		drawCanvas();
		Scene scene = new Scene(root);
		pstage.setTitle("Recursion Tree");
		pstage.setScene(scene);
		pstage.show();
	}

	void drawCanvas() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.rgb(100, 153, 0, 1));
		drawTree(gc, W/2, H, len, 0, N);
	}
	void drawTree(GraphicsContext gc, double x1, double y1, double len , double stand, int n){
		double x2= x1 + len*Math.sin(Math.toRadians(stand));  //枝先のx座標
		double y2= y1 - len*Math.cos(Math.toRadians(stand));
		gc.strokeLine(x1, y1, x2, y2);
		if (n >= 1) {  
			drawTree(gc, x2, y2, len*scale, stand-angle, n-1); //次の左の枝を描く
			drawTree(gc, x2, y2, len*scale, stand+angle, n-1); //次の右の枝を描く
		}
	}

	public static void main(String... args) {
		launch(args);
	}
}
