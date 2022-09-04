package chap17;
//URL を使ったHTTP クライアント 天気データへアクセス GUI版
//  コンパイルにはjson解析用jarファイルを指定
//  javac -classpath json-simple-1.1.1.jar WeatherClientGUI.java 
//  java -classpath .:json-simple-1.1.1.jar WeatherClientGUI

import javafx.application.Application;
import javafx.event.*;  //ActionEvent
import javafx.scene.Scene;  //Scene
import javafx.scene.control.*;   // Label etc
import javafx.scene.layout.*;  //VBox
import javafx.stage.Stage;  //Stage
import javafx.scene.image.*; //Image, ImageView

import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class WeatherClientGUI extends Application {
    Label laPlace, laTemp, laMax, laMin, laHumi, laTenki;
    
    @Override
    public void start(Stage pstage) {
        //ラベル
        laPlace = new Label("場所を上に指定"); //天気表示ラベル
        laTenki = new Label(" "); //天気表示ラベル
        laTenki.setPrefHeight(50);
        laTemp = new Label(" "); //気温表示ラベル
        laMax = new Label(" "); //最高気温表示ラベル
        laMin = new Label(" "); //最低気温表示ラベル
        laHumi = new Label(" "); //湿度表示ラベル
        GridPane gpane = new GridPane();
        gpane.addRow(0, new Label("気温"), laTemp);
        gpane.addRow(1, new Label("最高気温"), laMax);
        gpane.addRow(2, new Label("最低気温"), laMin);
        gpane.addRow(3, new Label("湿度"), laHumi);
        //チョイスボックス
        ComboBox <String> cb  = new ComboBox<String>();
        cb.setEditable(true);
        cb.getItems().addAll("Tokyo", "Toyohashi", "Kyoto", "Tsukuba");
        //コンテナに配置
        VBox root = new VBox();
        root.getChildren().addAll(cb, laPlace, laTenki, gpane);  
        //スタイル指定
        gpane.getStyleClass().add("gridpane");
        cb.getStyleClass().add("combobox");
        root.getStyleClass().add("vbox");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("comboBoxEvent.css");
        pstage.setTitle("Show Weather");
        pstage.setScene(scene);
        pstage.show();

        //Action Eventハンドラの設定
        cb.setOnAction( (ActionEvent event)-> {
            String item = cb.getSelectionModel().getSelectedItem();
	        try {
	           accessToWeather(item);
	        }catch(IOException e){ System.out.println("openweatherからのデータ取得に失敗"); }
        });
    }
    
    void accessToWeather(String city) throws IOException {
        String host = "api.openweathermap.org/data/2.5/weather?q=";
        String key = "5bbb22c664c****";  //取得したAPIキー
        URL url = new URL("http://" + host + city + ",jp&units=metric&appid=" + key);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = in.readLine();
        //System.out.println(line);
        in.close();
        parseJSON(line);   
      }
    
    void parseJSON(String data){
        JSONObject obj = null;
        JSONParser parser = new JSONParser();
        try{
            obj = (JSONObject)parser.parse(data); 
        }catch(ParseException e){ }

        // 地点名
        String cityName = (String)obj.get("name");
        laPlace.setText(cityName);
        // 気温
        JSONObject mainObj = (JSONObject)obj.get("main");
        double currentTemp = Double.valueOf(String.valueOf(mainObj.get("temp")));
        double minTemp = Double.valueOf(String.valueOf(mainObj.get("temp_min")));
        double maxTemp = Double.valueOf(String.valueOf(mainObj.get("temp_max")));
        laTemp.setText(String.valueOf(currentTemp));
        laMax.setText(String.valueOf(maxTemp));
        laMin.setText(String.valueOf(minTemp));
        // 湿度
        long humidity = (long)mainObj.get("humidity");
        laHumi.setText(String.valueOf(humidity));
        // 天気
        JSONArray weatherArray =  (JSONArray)obj.get("weather");
        JSONObject weatherObj = (JSONObject)weatherArray.get(0);
        String weather = (String)weatherObj.get("main");
        laTenki.setText(weather);
        //天気アイコン
        String icon = (String)weatherObj.get("icon");
        laTenki.setGraphic(new ImageView("http://openweathermap.org/img/w/" + icon + ".png"));
    }
   
    public static void main(String[] args) {
        launch(args);
    }
}