package chap15;
import javafx.scene.shape.*;  //Circle
import javafx.scene.paint.*; //Color
import javafx.animation.*; //Transition
import javafx.util.*;      //Duration

public class Firefly2 extends Circle {
	double lastSize = 20;     //最後の半径
	double lastTime = 2;     //最終フレームまでの時間
	double flyw;   //点が置かれる領域の幅
	double flyh;   //点が置かれる領域の高さ
	public Firefly2(){
		makeLighting();
	}
	public Firefly2(double size, double time){
		lastSize = size;
		lastTime = time;
		makeLighting();
	}
	// 引数は，点の大きさ，アニメーションにかける時間，点が置かれたノードの幅と高さ
	public Firefly2(double size, double time, double w, double h){
		lastSize = size;
		lastTime = time;
		flyw = w;
		flyh = h;
		makeLighting();
	}
	void makeLighting(){
		//塗りを指定，円形グラデーション 黄色から透明へ変化
		setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
						new Stop(0, Color.YELLOW), new Stop(1, Color.TRANSPARENT)) );
		Timeline tline = new Timeline(  //2つのキーフレームを設定
			new KeyFrame(Duration.seconds(0),                    //開始時のフレーム
				(event) -> { setCenterX(Math.random()*flyw);
							 setCenterY(Math.random()*flyh); } , //位置をランダムに変えるイベント処理
				new KeyValue(radiusProperty(), 0) ),
			new KeyFrame(Duration.seconds(lastTime),            //lastTime秒後のフレーム
				new KeyValue(radiusProperty(), lastSize, Interpolator.EASE_IN) 
			)
		);
		tline.setCycleCount(Animation.INDEFINITE);
		tline.setAutoReverse(true);
		tline.play();
    }

}
