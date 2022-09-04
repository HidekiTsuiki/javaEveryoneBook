package graph;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.scene.paint.*; //Color
import javafx.scene.canvas.*;  //Canvas, GraphicsContext

public class Bifurcation extends Application {
    // a を動かす範囲を from と to で設定します。ここでは，全体である 0 から 4.0 にしてますが，
    // 動きが面白くなる 3.5 から 4.0 などにしたら，面白い絵が現れます。from と to を設定する
    // ユーザーインターフェースを考えるのも面白いでしょう。
    double from = 0;   
    double to = 4.0;    
    double width = 800;
    double height = 600;
    Canvas canvas = new Canvas(width, height);
    int count = 400;   // 何度繰り返すか
    int countomit = 100;  // 最初の何回の値を捨てるか最初の何回かを捨てると，初期値の取り方によらない，
                          // 繰り返しの極限の形が見えてきます。
    double a;
    double fun (double x){
        return x * (1-x) * a;
    }
    GraphicsContext gc;
    @Override
    public void start(Stage stage) {
	VBox root = new VBox();
        Scene scene = new Scene(root);
        stage.setTitle("Bifurcation");
        gc = canvas.getGraphicsContext2D();
        root.getChildren().addAll(canvas);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        draw();
    }
  
    void draw(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, width, height);
        gc.setFill(Color.RED);
        for(int c = 0;c <= width;c++){
	    a = from + (to - from) * c/width;
            double x = 0.5;
            for(int i = 0; i < count; i++){
                double y = fun(x);
                x = y;
                if (i > countomit){
                    gc.fillRect(c, y*height, 1, 1);
                }
            }
        }
    }
    public static void main(String... args) {
        launch(args);
    } 
}
