package chap15;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  //Pane
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.scene.paint.Color;

public class CanvasMoveByMouse extends Application {
	Canvas canvas;
	double fX, fY; //四角形左上角最初の位置
	double sX, sY; //マウスドラッグ時カーソルの位置
	double x1, y1, x2, y2; //描画用の座標
	@Override
	public void start(Stage pstage) {
		Pane root = new Pane();
		canvas = new Canvas(250, 250);
		drawCanvas(50, 50, 200, 200);
		root.getChildren().add(canvas);
		fX = 50;  //最初の四角左上角の位置
		fY = 50;
		canvas.setOnMouseDragged((event) -> {
			sX = event.getX();
			sY = event.getY();
			adjustPoint();
			drawCanvas(x1, y1, x2, y2);
	    });
		Scene scene = new Scene(root);
		pstage.setTitle("Canvas Example");
		pstage.setScene(scene);
		pstage.show();
    }
    
	void drawCanvas(double x1, double y1, double x2, double y2) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.setStroke(Color.RED);
		gc.setLineWidth(3);
		gc.strokeRect(x1, y1, x2-x1, y2-y1);
		gc.strokeLine(x1, y2, x2, y1);   // 直線
		gc.strokeLine(x1, y1, x2, y2);
    }

	void adjustPoint(){ //ドラッグ先の座標が始めの点より小さい場合の処理
		if(sX>=fX && sY>=fY) { //右下へドラッグ 変更なし
			x1=fX; x2=sX;
			y1=fY; y2=sY;
		}else if(sX<fX && sY<fY){ //左上へドラッグ ｘｙ座標交換
			x1=sX; x2=fX;
			y1=sY; y2=fY;
		}else if(sX>=fX && sY<fY){ //右上へドラッグ ｙ座標交換
			x1=fX; x2=sX;
			y1=sY; y2=fY;
		}else if(sX<fX && sY>=fY){ //左下へドラッグ ｘ座標交換
			x1=sX; x2=fX;
			y1=fY; y2=sY;
		}
	}
    public static void main(String... args) {
        launch(args);
    }    
}
