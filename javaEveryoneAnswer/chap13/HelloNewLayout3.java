package chap13;
// Hello New Layout (using GridPane)
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Button, Label
import javafx.scene.layout.*;   //Pane
import javafx.stage.Stage;  //Stage
import javafx.geometry.*; // Pos, HPos

public class HelloNewLayout3 extends Application {
	@Override
	public void start(Stage pstage) {
		Button b1 = new Button("ボタン1");
		Button b2 = new Button("ボタン２");
		Label label = new Label("こんにちは");
	
		GridPane root = new GridPane();
		root.add(label, 0, 0, 2, 1); 
		root.add(b1, 0, 1); 
		root.add(b2, 1, 1); 
		//root.setGridLinesVisible(true);
		root.setAlignment(Pos.CENTER);  //シーンの中央にGridPaneを置く
		GridPane.setHalignment(label, HPos.CENTER);  //labelを中央揃えにする
		Scene scene = new Scene(root);

		pstage.setTitle("New Layout 3");
		pstage.setScene(scene);
		pstage.sizeToScene();
        pstage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
