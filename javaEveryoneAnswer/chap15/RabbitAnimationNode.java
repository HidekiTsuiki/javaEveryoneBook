package chap15;
// うさぎのダンスアニメーション用クラス
import javafx.scene.layout.*;  // Pane
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.scene.image.*; //Image
import javafx.animation.*;

class RabbitAnimationNode extends Pane {
	Canvas canvas;
	int number = 0;       //表示する画像の番号
	int cell = 20;        //画像の数
	Image[] image;        //画像を格納する配列
	Image back;           //背景画像用変数
	long prevTime;        //前のフレームを描いた時間(ナノ秒)
	AnimationTimer timer; //タイマ

	RabbitAnimationNode(){
		back = new Image("rabbit/stage.png");
		image = new Image[cell];
		for (int i = 1; i <= cell; i++) {   //画像のロード
			image[i-1] = new Image("rabbit/rabbit" + i + ".png");
		}
	 
		canvas = new Canvas(back.getWidth(), back.getHeight());
		getChildren().add(canvas);
		drawCanvas();

		timer = new AnimationTimer() { //タイマーの生成
			@Override public void handle(long now){
				if (prevTime + 200_000_000 > now) return;  //0.2秒経過していなければ戻る
				prevTime = now;
				drawCanvas(); //描画
			}
		};
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
}