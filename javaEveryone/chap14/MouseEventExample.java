package chap14;
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //HBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView
 
public class MouseEventExample extends Application {
	@Override
	public void start(Stage pstage) {
		Image frog = new Image("frogSmile400.png");//画像オブジェクトの生成 
		Image muji = new Image("muji400.png");
		ImageView iv1 = new ImageView(muji);
		ImageView iv2 = new ImageView(muji);
		Label la1 = new Label("", iv1);
		Label la2 = new Label("", iv2);
		HBox root =new HBox();
		root.getChildren().addAll(la1, la2);
		root.getStyleClass().add("hbox");
		Scene scene = new Scene(root);
		scene.getStylesheets().add("labelstyle.css");
		pstage.setTitle("On Mouse");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
		//イベントハンドラの設定
		la1.setOnMouseEntered((event)-> {
			iv1.setImage(frog);
		});
		la1.setOnMouseExited((event)-> {
			iv1.setImage(muji);
		});
		la2.setOnMouseEntered((event)-> {
			iv2.setImage(frog);
		});
		la2.setOnMouseExited((event)-> {
			iv2.setImage(muji);
		});
	}
	public static void main(String[] args) {
		launch(args);
    }
}
