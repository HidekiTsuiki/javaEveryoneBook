package chap15;
import javafx.scene.shape.*;  //Circle
import javafx.scene.paint.*; //Color
import javafx.animation.*; //Transition
import javafx.util.*;      //Duration

public class Firefly extends Circle {
	double lastSize = 20;     //最後の半径
	double lastTime = 2;      //最終フレームまでの時間
	public Firefly(){
		makeLighting();
	}
	public Firefly(double size, double time){
		lastSize = size;
		lastTime = time;
		makeLighting();
	}
	void makeLighting(){
		//塗りを指定，円形グラデーション 黄色から透明へ変化
		setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
						new Stop(0, Color.YELLOW), new Stop(1, Color.TRANSPARENT)) );
		Timeline tline = new Timeline(               //2つのキーフレームを設定
			new KeyFrame(Duration.seconds(0), new KeyValue(radiusProperty(), 0) ),  //開始時のフレーム
			new KeyFrame(Duration.seconds(lastTime), //lastTime秒後のフレーム
						new KeyValue(radiusProperty(), lastSize, Interpolator.EASE_IN) )
		);
		tline.setCycleCount(Animation.INDEFINITE);
		tline.setAutoReverse(true);
		tline.play();
    }
}
