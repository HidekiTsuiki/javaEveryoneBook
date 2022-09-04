package chap13;
// Menu
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   //Menu, MenuItem
import javafx.scene.layout.*;  //VBox, Pane
import javafx.stage.Stage;  //Stage

public class MenuExample extends Application {
	@Override
	public void start(Stage pstage) {
		//メニュー
		MenuBar bar = new MenuBar();
		Menu m1 = new Menu("ファイル");
		MenuItem menuSave = new MenuItem("保存");
		MenuItem menuEnd = new MenuItem("終了");
		m1.getItems().addAll(menuSave, menuEnd);
		Menu m2 = new Menu("編集");
		MenuItem menuCopy = new MenuItem("コピー");
		m2.getItems().add(menuCopy);
		bar.getMenus().addAll(m1, m2);
		//空のエリア
		Pane p = new Pane();
		p.setPrefSize(200, 150);
		
		VBox root = new VBox();
		root.getChildren().addAll(bar, p);
		Scene scene = new Scene(root);
		pstage.setTitle("Menu Sample");
		pstage.setScene(scene);
		pstage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}
}
