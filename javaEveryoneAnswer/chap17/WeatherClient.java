package chap17;
//  URL を使ったHTTP クライアント 天気データへアクセス
//  コンパイルにはjson解析用jarファイルを指定
//  javac -classpath json-simple-1.1.1.jar WeatherClient.java 
//  java -classpath .:json-simple-1.1.1.jar WeatherClient


import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class WeatherClient {
	public static void main(String[] args) throws IOException {
		WeatherClient wc = new WeatherClient();
		wc.accessToWeather();
	}

	void accessToWeather() throws IOException{
		String host = "api.openweathermap.org/data/2.5/weather?q=";
		String city = "Kyoto";
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
		System.out.println("都市：" + cityName);

		// 気温
		JSONObject mainObj = (JSONObject)obj.get("main");
		double currentTemp = Double.valueOf(String.valueOf(mainObj.get("temp")));
		double minTemp = Double.valueOf(String.valueOf(mainObj.get("temp_min")));
		double maxTemp = Double.valueOf(String.valueOf(mainObj.get("temp_max")));
		System.out.println("気温：" + currentTemp + " 最低気温：" + minTemp + " 最高気温：" + maxTemp);
		// 湿度
		long humidity = (long)mainObj.get("humidity");
		System.out.println("湿度：" + humidity);
		// 天気
		JSONArray weatherArray =  (JSONArray)obj.get("weather");
		JSONObject weatherObj = (JSONObject)weatherArray.get(0);
		String weather = (String)weatherObj.get("main");
		System.out.println("天気：" + weather);
	}
}
