package chap15;
// 超簡易描画エディタ
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.shape.*;  //Rectangle, Line, Ellipse
import javafx.scene.control.*;   // Button
import javafx.scene.layout.*;  // Pane, VBox, HBox 
import javafx.geometry.*;
import javafx.scene.paint.*; //Color

public class DrawEditor extends Application {
	Pane upperPane; //上部コンテナ(描画エリア)
	final int RECT = 1, OVAL = 2 , LINE=3, CLEAR = 0;
	int type = RECT;   //描く図形の種類, 初期値は四角
	double fX, fY, sX, sY; //マウスカーソルの位置 最初の押下時とドラッグ中の位置
	Shape target; //対象となっているノード
	double w = 400, h = 400;
	@Override
    public void start(Stage pstage) {
		//下部ボタンコンテナ
		Button b1 = new Button("四角");
		Button b2 = new Button("楕円");
		Button b3 = new Button("線分");
		Button b4 = new Button("クリア");
		HBox lowerPane = new HBox(); 
		lowerPane.setAlignment(Pos.CENTER);
		lowerPane.getChildren().addAll(b1, b2, b3, b4);
		lowerPane.setPadding(new Insets(15, 10, 15, 10));
		lowerPane.setSpacing(20);
		//上部コンテナ
		upperPane = new Pane();
		upperPane.setPrefSize(w, h);
		upperPane.setStyle("-fx-background-color:#ffffff");
	
		VBox root = new VBox();
		root.getChildren().addAll(upperPane, lowerPane);
		Scene scene = new Scene(root);
		pstage.setTitle("Drawing Editor");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
	
        //イベントハンドラの設定
		upperPane.setOnMousePressed((event)  -> {
			fX = event.getX();
			fY = event.getY();
			makeShape();
		});
		upperPane.setOnMouseDragged((event)  -> {
	    	sX = event.getX();
	    	sY = event.getY();
	    	if(type == LINE) {
				((Line)target).setEndX(sX);
				((Line)target).setEndY(sY);
			}else if(type == RECT){
				//描画用の座標
				double x1 = fX, x2 = sX;
		    	double y1 = fY, y2 = sY;
				if(sY<fY){ //上へドラッグ ｙ座標交換
					y1=sY; y2=fY;
				}else if(sX<fX){ //左へドラッグ ｘ座標交換
					x1=sX; x2=fX;
				}
				((Rectangle)target).setX(x1);
				((Rectangle)target).setY(y1);
				((Rectangle)target).setWidth(x2-x1);
				((Rectangle)target).setHeight(y2-y1);
			}else if(type == OVAL){
				((Ellipse)target).setCenterX(fX);
				((Ellipse)target).setCenterY(fY);
				((Ellipse)target).setRadiusX(Math.abs(fX-sX));
				((Ellipse)target).setRadiusY(Math.abs(fY-sY));
			}
		});
		b1.setOnAction((event)-> {
			type = RECT;
		});
		b2.setOnAction((event) -> {
			type = OVAL;
		});
		b3.setOnAction((event)-> {
			type = LINE;
		});
		b4.setOnAction((event) -> {
			type = CLEAR;
		});
	}
    void makeShape(){
		if(type == RECT){
			target = new Rectangle(fX, fY, 0, 0);
		} else if (type == OVAL){
			target = new Ellipse(fX, fY, 0, 0);
		} else if (type == LINE){
			target = new Line(fX, fY, fX, fY);
		} else {
			return;
		}
		target.setFill(Color.TRANSPARENT);
		target.setStroke(Color.BLACK);
		target.setStrokeWidth(2);
		upperPane.getChildren().add(target);
		Shape localtarget = target;
	   	target.setOnMouseClicked((event) -> {
			if (type == CLEAR){
				upperPane.getChildren().remove(localtarget);  
				//削除する対象のShapeオブジェクトを指定。
				// remove の引数を target とすると，
				// その時の target に代入されているものが remove されてしまう
				// localtarget にコピーしてラムダ式の取り込みを用いている。
			}
		});
	}

	public static void main(String... args) {
		launch(args);
	} 
}