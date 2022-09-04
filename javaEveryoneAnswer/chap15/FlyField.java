package chap15;
import javafx.application.Application;
import javafx.scene.*;  //Scene
import javafx.stage.Stage;
import javafx.scene.layout.*;   //Pane
import javafx.scene.shape.*;  //Rectangle

public class FlyField extends Application {
	Pane root;
	Firefly flies[];
	double w = 400, h = 400;
	@Override
	public void start(Stage pstage) {
		root = new Pane();
		root.setPrefSize(w, h);
		Scene scene = new Scene(root);
		makeShapes();
		pstage.setTitle("Fly Field");
		pstage.setScene(scene);
		pstage.show();
	}
	void makeShapes() {
		root.getChildren().add(new Rectangle(0, 0, w, h));
		flies = new Firefly[10];
		for(int i=0; i<flies.length; i++){
			//最小サイズ10, 変化の最小経過時間
			flies[i] = new Firefly(Math.random()*30+10, Math.random()*5+2);
			flies[i].setCenterX(Math.random()*w);
			flies[i].setCenterY(Math.random()*h);
			root.getChildren().add(flies[i]);
		}
	}

    public static void main(String... args) {
        launch(args);
    }    
}
