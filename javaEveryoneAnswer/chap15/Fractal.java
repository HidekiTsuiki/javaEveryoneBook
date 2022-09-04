package chap15;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  //Pane
import javafx.scene.input.*; //MouseEvent
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.scene.control.*;  //RadioButton
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.geometry.*;  //Pos


public class Fractal extends Application {
    RadioButton red, blue, both;

    int which;           // ラジオボタンでどれが選択されているか覚えておく
    int n = 15;          // 繰り返し回数
    double m = 200;      // 1辺の長さ
    double XA = m, YA = m*2, XB = m*2, YB=m*2;
    double xxa = m + m/2, yya = 2*m-m/2;
    double xxb = m + m/2, yyb = 2*m-m/2;
    final double W = m * 3, H = m * 3;
    double sina, cosa, sinb, cosb;
    //描画域 動く絵のために，Canvas をもう一つ用意。両方を Pane に載せる。
    Canvas canvas = new Canvas(W, H);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Pane p = new Pane(canvas);

    
   
    
    @Override
    public void start(Stage pstage) {
        //ラジオボタン
        HBox control = new HBox();
        red = new RadioButton("赤");  
        blue = new RadioButton("青");  
        both = new RadioButton("両方");
        ToggleGroup group = new ToggleGroup();
        red.setToggleGroup(group);
        blue.setToggleGroup(group);
        both.setToggleGroup(group);
        both.setSelected(true);

        
        control.setAlignment(Pos.CENTER);
        control.setSpacing(50);
//        control.getChildren().addAll(red, blue, both); 

        // 縮小写像の表示のため  ボタンが押された時の処理は，mytranslation の中で行う。
        Button b = new Button("２つの縮小写像");
        b.setOnAction(e-> mytranslation());
        control.getChildren().addAll(b, red, blue, both); 
        // 縮小写像の表示のため(ここまで)

        
        //全体のコンテナ
        BorderPane root = new BorderPane();
        root.setBottom(control);
        root.setCenter(p);
        root.setStyle("-fx-background-color: white");
        control.setStyle("-fx-background-color: aliceblue");
        drawit(gc);
		Scene scene = new Scene(root);
        pstage.setTitle("Fractal");
        pstage.setScene(scene);
        pstage.show();

        
        canvas.setOnMousePressed((MouseEvent e) -> {
            setvariables(e);
                drawit(gc);
            });
        canvas.setOnMouseDragged((MouseEvent e) -> {
                setvariables(e);
                drawit(gc);
            });
    }
    void setvariables(MouseEvent e){
        if(red.isSelected()) which = 1;
        if(blue.isSelected()) which = 2;
        if(both.isSelected()) which = 3;

        if(which == 1 || which == 3){
            xxa = e.getX();
            yya = e.getY();
        }
        if(which == 2 || which == 3){
            xxb = e.getX();
            yyb = e.getY();
        }
    }
    
    void drawit(GraphicsContext gc1){
        gc1.clearRect(0, 0, gc1.getCanvas().getWidth(), gc1.getCanvas().getHeight());
        sina = (double)(yya - YA)/m;
        cosa = (double)(xxa - XA)/m;
        sinb = (double)(yyb - YB)/m;
        cosb = (double)(xxb - XB)/m;
        levi(gc1, XA,YA,XB,YB,n);

        gc1.setFill(Color.BLUE); gc1.fillOval(xxb-5,yyb-5,10,10);
        gc1.setFill(Color.RED); gc1.fillOval(xxa-5,yya-5,10,10);
        gc1.setFill(Color.LIME); gc1.fillOval(XA-5,YA-5,10,10);
        gc1.setFill(Color.LIME); gc1.fillOval(XB-5,YB-5,10,10);
    }

    void levi(GraphicsContext gc1, double x1, double y1, double x2, double y2, int n){
        if(n == 0){
            gc1.strokeLine(x1, y1, x2, y2);
        }else{
            double x3 = x1 + (x2-x1)* cosa - (y2-y1)*sina;
            double y3 = y1 + (y2-y1)* cosa + (x2-x1)*sina;
            double x4 = x2 + (x2-x1)* cosb -(y2-y1)* sinb;
            double y4 = y2 + (y2-y1)* cosb + (x2-x1)*sinb;
            levi(gc1, x1, y1, x3,y3, n-1);
            levi(gc1, x4, y4, x2,y2, n-1);
        }
    }

    public static void main(String... args) {
        launch(args);
    }    

    // 縮小写像の表示のため
    /* Transltion で行えればよいが，残念ながら，transition は，node の中心を中心とした回転しかサポートしない。
        縮小写像の回転のために，２つキャンバスを余分に用意しておく。
	    回転させたい２つのキャンバスに対し Rotate, Scale という Transformation を設定し，
    	timeline を作成して，Rotate, Scale の angle, x, y という property を変化させる
    	ことにより行う。 
    	*/
    void mytranslation(){
        Canvas canvasleft = new Canvas(W, H);
        GraphicsContext gcleft = canvasleft.getGraphicsContext2D();
        Canvas canvasright = new Canvas(W, H);
        GraphicsContext gcright = canvasright.getGraphicsContext2D();
        p.getChildren().add(canvasleft);
        p.getChildren().add(canvasright); 
    	
    	Rotate rleft = new Rotate(0, XA,YA);
    	Scale sleft = new Scale(1, 1, XA, YA);
    	canvasleft.getTransforms().add(rleft);
    	canvasleft.getTransforms().add(sleft);
    	gcleft.setStroke(Color.RED);
    	drawit(gcleft);
    	double lenleft = Math.sqrt(sina*sina + cosa * cosa); 

    	new Timeline(new KeyFrame(Duration.millis(0), new KeyValue(rleft.angleProperty(), 0),
		            new KeyValue(sleft.xProperty(), 1),
		            new KeyValue(sleft.yProperty(), 1)),
			     new KeyFrame(Duration.millis(1000), 
					new KeyValue(rleft.angleProperty(), Math.asin(sina/lenleft)/Math.PI*180),
	        		new KeyValue(sleft.xProperty(), lenleft),
	        		new KeyValue(sleft.yProperty(), lenleft)))
			    .play();

    	Rotate rright = new Rotate(0, XB,YB);
    	Scale sright = new Scale(1, 1, XB, YB);
    	canvasright.getTransforms().add(rright);
    	canvasright.getTransforms().add(sright);
    	double lenright = Math.sqrt(sinb*sinb + cosb * cosb); 

    	new Timeline(
    			new KeyFrame(Duration.millis(2000), (e)->{
    		    	gcright.setStroke(Color.BLUE);
    				drawit(gcright);
    			}),
    			new KeyFrame(Duration.millis(2000), new KeyValue(rright.angleProperty(), 0),
	            new KeyValue(sright.xProperty(), 1),
	            new KeyValue(sright.yProperty(), 1)),
		     new KeyFrame(Duration.millis(3000), 
				new KeyValue(rright.angleProperty(), -Math.asin(sinb/lenright)/Math.PI*180),
        		new KeyValue(sright.xProperty(), lenright),
        		new KeyValue(sright.yProperty(), lenright)),
		     new KeyFrame(Duration.millis(5000), 
		    		 (e)->{
		    			 p.getChildren().remove(canvasleft);
		    			 p.getChildren().remove(canvasright);
		     	 }))    	
    	.play();

    }
}
