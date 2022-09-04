package chap14;
import javafx.application.Application;

import javafx.event.*;  //ActionEvent
import javafx.scene.input.*; //MouseEvent
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //HBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*;    //Image, ImageView

public class WhereFrog extends Application {
	@Override
	public void start(Stage pstage) {
		Image frog = new Image("frogSmile400.png");//画像オブジェクトの生成 
		Image frogNo = new Image("frogNo400.png");//画像オブジェクトの生成 
		Image muji = new Image("muji400.png");
		ImageView iv1 = new ImageView(muji);
		ImageView iv2 = new ImageView(muji);
		Label la1 = new Label("", iv1);
		Label la2 = new Label("", iv2);
		la1.setContentDisplay(ContentDisplay.CENTER);
		la2.setContentDisplay(ContentDisplay.CENTER);
		la1.setStyle("-fx-font-size: 40;");
		la2.setStyle("-fx-font-size: 40;");
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
		EventHandler<MouseEvent> hExit = (event)-> {
			iv1.setImage(muji);
			iv2.setImage(muji);
			la1.setText("");
			la2.setText("");
		};
		EventHandler<MouseEvent> hEnter = (event)-> {
			int r = (int)(Math.random()*2);//0：左にいる，1:右にいる
			if(event.getSource() == la1){
	        	if(r==0) {
					iv1.setImage(frog);
					la1.setText("あたり!");
				} else {
					iv2.setImage(frogNo);
					la2.setText("はずれ！");
				}
			}else if(event.getSource() == la2){
				if(r==0) {
			    	iv1.setImage(frogNo);
					la1.setText("はずれ！");
				} else {
               		iv2.setImage(frog);
					la2.setText("あたり!");
				}
	     	}
		};
		la1.setOnMouseEntered(hEnter);
		la1.setOnMouseExited(hExit);
		la2.setOnMouseEntered(hEnter);
		la2.setOnMouseExited(hExit);
	}
	public static void main(String[] args) {
		launch(args);
    }
}
