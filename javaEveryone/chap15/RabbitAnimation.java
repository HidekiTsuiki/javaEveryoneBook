package chap15;
// うさぎのダンスアニメーション
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;   //Pane
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.scene.image.*; //Image
import javafx.animation.*;

public class RabbitAnimation extends Application {
	Canvas canvas;
	int number = 0;       //表示する画像の番号
	int cell = 20;        //画像の数
	Image[] image;        //画像を格納する配列
	Image back;           //背景画像用変数
	long prevTime;        //前のフレームを描いた時間(ナノ秒)
	AnimationTimer timer; //アニメーション用タイマー
	@Override
	public void start(Stage pstage) {
		back = new Image("rabbit/stage.png");
		image = new Image[cell];
		for (int i = 1; i <= cell; i++) {   //画像のロード
			image[i-1] = new Image("rabbit/rabbit" + i + ".png");
		}
		Pane root = new Pane();
		canvas = new Canvas(back.getWidth(), back.getHeight());
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		pstage.setTitle("Rabbit Animation");
		pstage.setScene(scene);
		pstage.show();
		timer = new AnimationTimer() { //タイマーの生成
			@Override public void handle(long now){
				if (prevTime + 200_000_000 > now) return;  //0.2秒経過していなければ戻る
				prevTime = now;
				drawCanvas(); //描画
			}
		};
		timer.start();   //アニメーションの開始
    }

	void drawCanvas() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(back, 0, 0);
		double x = gc.getCanvas().getWidth()/2-30; //ウィンドウのほぼ中央にうさぎを表示
		double y = gc.getCanvas().getHeight()/2+20;
        gc.drawImage(image[number], x, y);
		number++;  
		number = number%cell;  //次に表示する画像の番号
    }

    public static void main(String... args) {
        launch(args);
    } 
}