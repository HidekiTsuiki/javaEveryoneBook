package chap16;
// csvファイルを読んで，折れ線グラフを描画
import java.io.*;
import java.util.*;


import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.stage.Stage;  //Stage
import javafx.scene.chart.*;

public class PopulationLine extends Application {
	ArrayList<Integer> year = new ArrayList<Integer>();  //一行目, 年
	ArrayList<String> name = new ArrayList<String>();  //一列目, 地域
	ArrayList<ArrayList<Double>> population = new ArrayList<ArrayList <Double>>();  //地域ごと年ごとの値
	LineChart<String, Number> chart;
	@Override
	public void start(Stage pstage) {
		dataRead();

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("年");
		yAxis.setLabel("人口(100万人)");
		chart = new LineChart<String, Number> (xAxis, yAxis);  // 折れ線チャート
		chart.setTitle("世界の人口の推移");

		createXYData();

		Scene scene = new Scene(chart, 800, 600);
		scene.getStylesheets().add("chartStyle.css");
		pstage.setTitle("World Population");
		pstage.setScene(scene);
		pstage.show();
	}

	void dataRead() {   //csvファイルを読む
		String s;
		try( BufferedReader din = new BufferedReader(new FileReader("population.csv")); ){  
			if((s=din.readLine()) != null){  //1行目を読む
				Scanner sc = new Scanner(s);
				sc.useDelimiter(",");
				while (sc.hasNextInt()) {  //整数値を読む
					year.add(sc.nextInt());
				}
				sc.close();
			}
			//System.out.println(year);
			while( (s=din.readLine()) != null ){  //2行目以降を読む
				Scanner sc = new Scanner(s);     
				sc.useDelimiter(",");
				String area = null;   //地域
				if(sc.hasNext()) {
					area = sc.next();  //文字列を読む
					name.add(area);
				}
				ArrayList<Double> row = new ArrayList<Double>(); //行のデータ 
				while (sc.hasNextDouble()) {  //実数値を読む
					row.add(sc.nextDouble());
				}
				sc.close();
				//System.out.println(area + "  " + row);
				population.add(row);
			} 
		}catch(IOException error) { System.out.println("読み込みエラー発生");}
	}

	void createXYData(){  //引数で受け取ったXYChartにデータを設定
		for(int i=0; i<population.size(); i++){  //地域ごとに
			XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();  // ある県の線
			series.setName(name.get(i));
			for(int j=0; j<year.size(); j++){  // 折れ線の値を設定，年分くりかえす
			series.getData().add(new XYChart.Data<>(year.get(j).toString(), 
									population.get(i).get(j).doubleValue()));
			}
			chart.getData().add(series);  // グラフにひとつの地域の線データを追加
		}
	}

	public static void main(String[] args){
		launch(args);
   }
}
