package chap15;
// 木のフラクタル
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.scene.paint.*; //Color
import javafx.scene.canvas.*;  //Canvas, GraphicsContext
import javafx.geometry.*;   // Pos

public class TreeChange extends Application {
	Canvas canvas;
	final double W = 400, H = 400;
	double scale = 0.7;  //枝の短くなる比率
	double angle = 30; //枝の広がり
	double len = 110;  //最初の枝の長さ
	int N = 8; //枝別れの段数

	@Override
    public void start(Stage pstage) {
		//下部スライドコンテナ
		//角度用スライダー
		Slider sliderA = new Slider(0, 100, angle);
		sliderA.setShowTickLabels(true);
		sliderA.setShowTickMarks(true);
		sliderA.setPrefWidth(200);
		Label labelA = new Label(String.format("%.2f", angle));
		HBox paneA = new HBox();
		paneA.setPadding(new Insets(30, 10, 10, 30));
		paneA.setSpacing(20);
		paneA.getChildren().addAll(new Label("角度　　　"), sliderA, labelA);
		paneA.setStyle("-fx-background-color:#ffffff");
		//枝の比率用スライダー
		Slider sliderR = new Slider(0, 1, scale);
		sliderR.setShowTickLabels(true);
		sliderR.setShowTickMarks(true);
		sliderR.setMajorTickUnit(0.2);
		sliderR.setPrefWidth(200);
		Label labelR = new Label(String.format("%.2f", scale));
		HBox paneR = new HBox();
		paneR.setPadding(new Insets(10, 10, 10, 30));
		paneR.setSpacing(20);
		paneR.getChildren().addAll(new Label("枝長の比率"),sliderR, labelR);
		paneR.setStyle("-fx-background-color:#ffffff");
		//2つのスライダをのせる
		VBox lowerPane = new VBox();
		lowerPane.getChildren().addAll(paneA, paneR);
		//上部コンテナ
		Pane upperPane = new Pane();
		canvas = new Canvas(W, H);
		upperPane.getChildren().add(canvas);
        drawCanvas();
		//全体配置
		VBox root = new VBox();
		root.getChildren().addAll(upperPane, lowerPane);
        Scene scene = new Scene(root);
		pstage.setTitle("Tree with slider");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
		
		//イベント処理　スライダーが変化したらラベルの値を変更
		sliderA.valueProperty().addListener((ov, oldValue, newValue) -> {  //リスナーの指定
			angle = newValue.doubleValue();
			labelA.setText(String.format("%.2f", angle));
			drawCanvas();
        });
		sliderR.valueProperty().addListener((ov, oldValue, newValue) -> {  //リスナーの指定
			scale = newValue.doubleValue();
			labelR.setText(String.format("%.2f", scale));
			drawCanvas();
        });
    }

	void drawCanvas() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.rgb(100, 153, 0, 1));
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, W, H);
		drawTree(gc, W/2, H, len, 0, N);
    }
	
	void drawTree(GraphicsContext gc, double x1, double y1, double len , double stand, int n){
		double x2= x1 + len*Math.sin(Math.toRadians(stand));  //枝先のx座標
		double y2= y1 - len*Math.cos(Math.toRadians(stand));
		gc.strokeLine(x1, y1, x2, y2);
		if (n >= 1) {  
			drawTree(gc, x2, y2, len*scale, stand-angle, n-1); //次の左の枝を描く
			drawTree(gc, x2, y2, len*scale, stand+angle, n-1); //次の右の枝を描く
		}
	}

	public static void main(String... args) {
		launch(args);
	} 
}