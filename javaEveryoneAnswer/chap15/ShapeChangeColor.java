package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.stage.Stage; //Stage
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  // Circle
import javafx.scene.paint.*; //Color

public class ShapeChangeColor extends Application {
	Pane root;
	@Override
    public void start(Stage pstage) {
        root = new Pane();
		root.setPrefSize(220, 220);
        makeShapes();
		Scene scene = new Scene(root);
        pstage.setTitle("Shape Circle Color");
        pstage.setScene(scene);
        pstage.show();
    }

    void makeShapes() {
        Circle cir[][] = new Circle[10][10];
		double x,y;
        for(int i=0; i<10; i++){
           x = 20*(i+1);
           for(int j=0; j<10; j++){
				y = 20*(j+1);
				cir[i][j] = new Circle(x, y, 10);
	       		root.getChildren().add(cir[i][j]);
	       		cir[i][j].setOnMouseEntered((event) -> { 
	              ((Circle)event.getSource()).setFill(Color.RED); });
            }
        }
    }

    public static void main(String... args) {
        launch(args);
    }
}
