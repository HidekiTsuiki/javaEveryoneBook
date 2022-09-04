package chap15;
import javafx.application.Application;
import javafx.stage.Stage; //Stage
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Rectangle, Line
import javafx.scene.paint.Color;


public class ShapeMoveByMouse extends Application {
	Pane root;
	double fX, fY; //四角形左上角最初の位置
	double sX, sY; //マウスドラッグ時カーソルの位置
	@Override
	public void start(Stage pstage) {
	root = new Pane();
		root.setPrefSize(250, 250);
		makeShapes();
		Scene scene = new Scene(root);
		pstage.setTitle("Shape Move by Mouse");
        pstage.setScene(scene);
        pstage.show();
    }

    void makeShapes() {
		Rectangle rect = new Rectangle(50, 50, 150, 150);
		Line line1 = new Line(50, 200, 200, 50);
		Line line2 = new Line(50, 50, 200, 200);
		rect.setStrokeWidth(3);
		rect.setStroke(Color.RED);
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(Color.RED);
		line1.setStrokeWidth(3);
		line2.setStrokeWidth(3);
		line1.setStroke(Color.RED);
		line2.setStroke(Color.RED);
		root.getChildren().addAll(rect, line1, line2);
		fX = rect.getX();
		fY = rect.getY();
		root.setOnMouseDragged((event) -> {
			sX = event.getX();
			sY = event.getY();
			double x1=fX, x2=sX;
			double y1=fY, y2=sY;
			if(sY<fY){ //上へドラッグ ｙ座標交換
			    y1=sY; y2=fY;
			}
			if(sX<fX){ //左へドラッグ ｘ座標交換
			    x1=sX; x2=fX;
			}
			rect.setX(x1);
			rect.setY(y1);
			rect.setWidth(x2-x1);
			rect.setHeight(y2-y1);
			line1.setStartX(x1);
			line1.setStartY(y1);
			line1.setEndX(x2);
			line1.setEndY(y2);
			line2.setStartX(x1);
			line2.setStartY(y2);
			line2.setEndX(x2);
			line2.setEndY(y1);
		});
	}

	public static void main(String... args) {
		launch(args);
	}
}
