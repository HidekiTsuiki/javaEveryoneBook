package chap15;
// ボールがはねる
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  //Pane
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.animation.*;

public class BoundBall extends Application {
	Canvas canvas;
	double w = 400;  // 画面サイズ
	double h = 400;
	double x = 0; // ボールX座標
	double y = 0;   // ボールY座標
	double diameter = 10.0; // ボール直径
	double speedX = 2; // ボールX軸速度
	double speedY = 2; // ボールY軸速度
	double directionX = 1; // ボールX軸移動向き
	double directionY = -1; // ボールY軸移動向き

	@Override public void start(Stage pstage) {
		Pane root = new Pane();
		canvas = new Canvas(w, h);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		pstage.setTitle("Bound Ball");
		pstage.setScene(scene);
		pstage.show();
		AnimationTimer timer = new AnimationTimer() { //タイマーの生成
			@Override public void handle(long now){
				drawCanvas();
			}
		};
		timer.start();   //アニメーションの開始
    }

	void drawCanvas() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, w, h);  // 背景塗る
		x += speedX * directionX;  // 座標計算
		y += speedY * directionY;
		if (x > w-diameter) {   // 右の壁
			x = w-diameter;
			directionX = -directionX; // x方向変換
			speedX = Math.random()*6+2; //スピードを2−８にする。
			speedY = Math.random()*3+2;
		} else if (x < 0) { // 左の壁
			x = 0;
			directionX = -directionX; // x方向変換
			speedX = Math.random()*6+2;
			speedY = Math.random()*3+2;
		}
		if (y > h-diameter) { //下の壁
			y = h-diameter;
			directionY = -directionY; // y方向変換
			speedX = Math.random()*6+2;
			speedY = Math.random()*3+2;
		}else if (y < 0) {     // 上の壁
			y = 0;
			directionY = -directionY; // y方向変換
			speedX = Math.random()*6+2;
			speedY = Math.random()*3+2;
		}
		gc.fillOval(x, y, diameter, diameter);   //円
	}

	public static void main(String... args) {
		launch(args);
	} 
}