package chap14;
import javafx.application.Application;
import javafx.scene.input.*; //MouseEvent
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //HBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView
 
public class KeyEventExample extends Application {
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
		pstage.setTitle("On Key");
		pstage.setScene(scene);
		pstage.sizeToScene();
		pstage.show();
		//イベントハンドラの設定
		scene.setOnKeyPressed((event)-> {
			if(event.getCode() == KeyCode.L){
				iv1.setImage(frog);
			}else if(event.getCode() == KeyCode.R){
				iv2.setImage(frog);
			}
		});
		scene.setOnKeyReleased((event)-> {
			iv1.setImage(muji);
			iv2.setImage(muji);
		});
	}
	public static void main(String[] args) {
		launch(args);
	}
}
