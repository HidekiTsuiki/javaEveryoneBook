package graph;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;  // VBox, HBox 
import javafx.scene.paint.*; //Color
import javafx.scene.canvas.*;  //Canvas, GraphicsContext

public class GraphDrawerFX extends Application {
    Canvas canvas;
    double width = 400;
    double a = 3.5;
    double fun (double x){
        return x * (1-x) * a;
    }
    GraphicsContext gc;
    SimpleTurtle m = new SimpleTurtle();
    @Override
    public void start(Stage stage) {
        //スライダー
        Slider slider = new Slider(0, 4, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.5);
        slider.setPrefWidth(200);

        canvas = new Canvas(width, width);
        VBox root = new VBox();
        root.getChildren().addAll(canvas, slider);
        Scene scene = new Scene(root);
        stage.setTitle("Unimodal Map");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, width, width);
        //イベント処理　
        slider.valueProperty().addListener((ov, oldValue, newValue) -> {  //リスナーの指定
                a = newValue.doubleValue();
                gc.fillRect(0, 0, width, width);
                gc.setLineWidth(1.0);m.drawGraph();
                m.dynamics(0.5, 100);
            });
    }
    
    
    class SimpleTurtle {    //up, down, dMoveTo で TurtleGraphics を再現
        double cx=0, cy=0;  // 現在の Frame 上の座標,
        boolean isDown = true;
        void up(){ isDown = false;}
        void down(){ isDown = true;}
        void dMoveTo(double x, double y){
            double nx = x * width;
            double ny = (1- y) * width;
            if(isDown){
                gc.strokeLine(cx, cy, nx, ny);
            }
            cx = nx;
            cy = ny;
        }
        void drawGraph(){
            up(); dMoveTo(0, fun(0)); down();
            for(double x = 0; x < 1; x+= 1/width){
                dMoveTo(x, fun(x));  
            }
        }
        void drawLine(double x, double y, double ex, double ey){
            up(); dMoveTo(x,y); down(); dMoveTo(ex, ey);
        }
        void dynamics(double x, int count){
            gc.setLineWidth(0.2);m.drawLine(0, 0, 1, 1);
            gc.setLineWidth(0.5);gc.setStroke(Color.RED);
            up(); dMoveTo(x, 0); down();
            for(int i = 0; i < count; i++){
                double y = fun(x);
                dMoveTo(x, y);
                dMoveTo(y, y);
                x = y;
            }
            gc.setStroke(Color.BLACK);
        }
    }
    public static void main(String... args) {
        launch(args);
    } 
}
