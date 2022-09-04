package chap15;
// 超簡易描画エディタ
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.shape.*;  //Line
import javafx.scene.layout.*;  //Pane 

public class DrawByMouse extends Application {
	Pane pane;
	double fX, fY; //最初のマウスカーソルの位置
	Line target;   //ドラッグ描画中の線
	double w = 400, h = 400;
	@Override
	public void start(Stage pstage) {
	//描画域
		pane = new Pane();
		pane.setPrefSize(w, h);
		pane.setStyle("-fx-background-color:#ffffff");

		Scene scene = new Scene(pane);
		pstage.setTitle("Drawing by mouse");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	
        //イベントハンドラの設定
		pane.setOnMousePressed((event)  -> {
			fX = event.getX();
			fY = event.getY();
        	makeShape();
		});
		pane.setOnMouseDragged((event)  -> {
			target.setEndX(event.getX());
			target.setEndY(event.getY());
		});
	}
	void makeShape(){
		Line line = new Line(fX, fY, fX, fY);
		line.setStrokeWidth(2);
		pane.getChildren().add(line);
		target = line;
		}

	public static void main(String... args) {
		launch(args);
	} 
}