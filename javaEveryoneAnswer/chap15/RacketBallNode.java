package chap15;
// ラケットボール
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.shape.*;  //Circle, Rectangle
import javafx.scene.text.*;  // Text
import javafx.scene.layout.*;  //Pane
import javafx.animation.*;
import javafx.scene.paint.*; //Color

public class RacketBallNode extends Application {
    double w = 400;  // 画面サイズ
    double h = 400;
    double diameter = 10.0; // ボール半径
    double racketW = 50, racketH = 20;  //ラケットの幅高さ
    double ry = h-50; //ラケットの上からの位置
    double gh=10, gw=80;  //ゴールの幅高さ
    double gx = w/2-gw/2, gy=0;  //ゴールの位置


    double x = 0; // ボールX座標
    double y = 0;   // ボールY座標
    double speedX = 2; // ボールX軸速度
    double speedY = 2; // ボールY軸速度
    double directionX = 1; // ボールX軸移動向き
    double directionY = -1; // ボールY軸移動向き
    double rx;  //ラケットの左からの位置
    int point=0;
    boolean gameover = false;
    AnimationTimer timer;
    Pane pane;

    Circle ball = new Circle();
    Rectangle racket = new Rectangle(racketW, racketH);
    Rectangle goal = new Rectangle(gx, gy, gw, gh);
    Text pointText = new Text();
    Text gameOver = new Text(w/2-40, h/2, "Game over");

    @Override
    public void start(Stage pstage) {
        Pane root = new Pane();
        pane = new Pane();
        pane.setPrefSize(w, h);
        ball.setRadius(diameter/2);
        ball.setFill(Color.RED);
        racket.setTranslateY(ry);
        racket.setFill(Color.DODGERBLUE);
        goal.setFill(Color.DARKGREY);
        pointText.setX(10);
        pointText.setY(30);

        pane.getChildren().addAll(goal, racket, ball, pointText);
        root.getChildren().add(pane);
        Scene scene = new Scene(root);
        pstage.setTitle("Racket Ball");
        pstage.setScene(scene);
        pstage.show();
        timer = new AnimationTimer() { //タイマーの生成
            @Override public void handle(long now){
                    drawPane();
                }
            };
        timer.start();   //アニメーションの開始
        pane.setOnMouseMoved((event) -> { 
            rx = event.getX() - racketW/2;
            racket.setX(rx);
        });
        
        pane.setOnMouseClicked((event) -> { 
            if(gameover){
                gameover = false;
                pane.getChildren().remove(gameOver);                    
                x = 0;
                y = 0;
                ball.setCenterX(x);
                ball.setCenterY(y);
                point = 0;
                timer.start();   //アニメーションの開始
            }
        });
    }

    void drawPane() {
        if(gameover){
            timer.stop();
            pane.getChildren().add(gameOver);
            return;
        }
        x += speedX * directionX;  // 座標計算
        y += speedY * directionY;
        if (x > w-diameter) {   // 右の壁
            x = w - diameter;
            directionX = -directionX; // x方向変換
            speedX = Math.random()*6+2;
            speedY = Math.random()*3+2;
        } else if (x < 0) { // 左の壁
            x = 0;
            directionX = -directionX; // x方向変換
            speedX = Math.random()*6+2;
            speedY = Math.random()*3+2;
        }
        if (y > ry-diameter && y < ry+20 &&  x > rx && x < rx+racketW) { //ラケット表面
            y = ry-diameter;
            directionY = -directionY; // y方向変換
            speedX = Math.random()*6+2;
            speedY = Math.random()*3+2;
        }else if (y > h-diameter) { //下の壁
            gameover = true;
        }else if (y < 0) {     // 上の壁
            if(x>gx && x<gx+gw)  point=point +1; //ゴールに当たった
	    y = 0;
            directionY = -directionY; // y方向変換
            speedX = Math.random()*6+2;
            speedY = Math.random()*3+2;
        }
        ball.setTranslateX(x);
        ball.setTranslateY(y);
        pointText.setText("Point:" + point);	
    }

    public static void main(String... args) {
        launch(args);
    } 
}
