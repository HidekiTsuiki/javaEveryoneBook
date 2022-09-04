package chap16;
// 超簡易テキストエディタ
import javafx.application.Application;
import javafx.stage.*; //Stage, FileChooser
import javafx.scene.*;  //Scene
import javafx.scene.control.*;   // Button
import javafx.scene.layout.*;  // VBox
import javafx.geometry.*;
import java.io.*;  // File


public class TextEditor extends Application {
	double w = 600, h = 600;
	TextArea text;
	File file =  new File("Hello.java");  //編集するファイル
	@Override
	public void start(Stage stage) {
		//下部ボタンコンテナ
		Button openb = new Button("開く");
		Button saveb = new Button("保存");
		Button clearb = new Button("クリア");
		ComboBox <String> cb  = new ComboBox<String>();
		cb.getItems().addAll("UTF8", "UTF-16", "SJIS", "ISO2022JP", "EUC_JP");
		cb.getSelectionModel().selectFirst();  //先頭を選択
		HBox lowerPane = new HBox(); 
		lowerPane.setAlignment(Pos.CENTER);
		lowerPane.getChildren().addAll(openb, saveb, clearb, cb);
		lowerPane.setPadding(new Insets(15, 10, 15, 10));
		lowerPane.setSpacing(20);
		//上部コンテナ
		ScrollPane upperPane = new ScrollPane();
		upperPane.setPrefSize(w, h);
		upperPane.setFitToHeight(true); //ScrollPaneの高さにノードのサイズを変更
		upperPane.setFitToWidth(true); //ScrollPaneの幅にノードのサイズを変更
		text = new TextArea();
		upperPane.setContent(text);
	
		VBox root = new VBox();
		root.getChildren().addAll(upperPane, lowerPane);
		Scene scene = new Scene(root);
		stage.setTitle("Text Editor");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	
		dataRead(file);
	}
    
	void dataRead(File file) {   //一行ずつ読んで表示
		try( BufferedReader din = new BufferedReader(new FileReader(file)); )
		{
			String s;
			while((s = din.readLine()) != null){//ファイルの終わりまで、1行読み、
				text.appendText(s);  //ファイルの行をtextに追加
				text.appendText("\n");
			}
		}catch(IOException e) { System.out.println("読み込みエラー"); }
	}

	public static void main(String... args) {
		launch(args);
    } 
}