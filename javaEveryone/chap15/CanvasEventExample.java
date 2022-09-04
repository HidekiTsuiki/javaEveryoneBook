package chap15;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  //Pane
import javafx.scene.input.*; //MouseEvent
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.scene.image.*; //Image
import javafx.scene.paint.*; //ImagePattern


public class CanvasEventExample extends Application { 
	Canvas canvas;   //Canvas用インスタンスフィールド
	@Override
	public void start(Stage pstage) {
    	ImagePattern ip = new ImagePattern(new Image("goldfish.jpg"));
		ImagePattern ip2 = new ImagePattern(new Image("nofish.jpg"));
		Pane root = new Pane();
		canvas = new Canvas(200, 200);
		drawCanvas(ip2);
		root.getChildren().add(canvas);
		canvas.setOnMouseClicked((MouseEvent event) -> {  //マウスクリック時の処理
			GraphicsContext context = canvas.getGraphicsContext2D();
			if(context.getFill() == ip2) { drawCanvas(ip); }
			else if(context.getFill() == ip) { drawCanvas(ip2); }
		});
		Scene scene = new Scene(root);
		pstage.setTitle("Canvas Event Example");
		pstage.setScene(scene);
		pstage.show();
	}

	void drawCanvas(ImagePattern img) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(img);                 //塗りを設定
		gc.fillOval(25, 25, 150, 150);   //円
	}

	public static void main(String... args) {
		launch(args);
	}
}
