package chap13;
// 折れ線グラフを描画
import javafx.application.Application;
import javafx.scene.Scene;  //Scene
import javafx.stage.Stage;  //Stage
import javafx.scene.chart.*;

public class LineChartExample extends Application {
	int year [] = {1950,1955,1960,1965,1970,1975,1980,1985,1990,1995,2000,2005,2010,2015,2020,2025,2030,2035,2040,2045,2050};
	double data [] = {2525,2758,3018,3322,3682,4061,4440,4853,5310,5735,6127,6520,6930,7349,7758,8142,8501,8839,9157,9454,9725};
	LineChart<String, Number> chart;
	@Override
	public void start(Stage pstage) {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("年");
		yAxis.setLabel("人口(100万人)");
		chart = new LineChart<String, Number> (xAxis, yAxis);  // 折れ線チャート
		chart.setTitle("世界の人口の推移");
		chart.setLegendVisible(false);
		createXYData();

		Scene scene = new Scene(chart);
		//Scene scene = new Scene(chart, 800, 600);  //チャートのサイズを指定してもいい
		pstage.setTitle("World Population");
		pstage.setScene(scene);
		scene.getStylesheets().add("linechart.css");
		// pstage.sizeToScene();
		pstage.show();
	}

	void createXYData(){  //LineChartにデータを設定
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();  // ひとつの線
		//series.setName("世界");  //凡例の名前，今は表示していない
		for(int i=0; i<year.length; i++){  // 折れ線の値を設定，年分くりかえす
			series.getData().add(new XYChart.Data<>(String.valueOf(year[i]), data[i]));
		}
		chart.getData().add(series);  // グラフにひとつの線データを追加
	}

	public static void main(String[] args){
		launch(args);
	}
}
