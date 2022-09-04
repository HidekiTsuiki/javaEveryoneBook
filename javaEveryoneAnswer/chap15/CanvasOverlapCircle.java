package chap15;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  //Pane
import javafx.scene.input.*; //MouseEvent
import javafx.scene.canvas.*;  //Canvas, GraphicsContext

public class CanvasOverlapCircle extends Application {
	Canvas canvas;   //描画用キャンバス
	double d = 10;  //直径
	@Override
	public void start(Stage pstage) {
		Pane root = new Pane();
		canvas = new Canvas(250, 250);
		root.getChildren().add(canvas);
		canvas.setOnMouseMoved((MouseEvent event) -> { 
			drawCanvas(event.getX()-d/2, event.getY()-d/2);//マウス位置が円の中心
		});
		Scene scene = new Scene(root);
        pstage.setTitle("Draw circles by mouse");
        pstage.setScene(scene);
        pstage.show();
    }
    
	void drawCanvas(double x, double y) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.strokeOval(x, y, d, d);
	}

	public static void main(String... args) {
		launch(args);
	}    
}
