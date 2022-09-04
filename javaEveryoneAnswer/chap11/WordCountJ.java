package chap11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class WordCountJ {
    String file = "sampleJ.txt";
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	public static void main(String[] args) {
		new WordCountJ().start();
	}
	void start(){
		read();
//		count("言語");
		count("オブジェクト");
	}
	void count(String s){
		System.out.println("Number of \"" + s + "\": " + hm.get(s));
	}
	
	void read(){
		/* HashMapAsk.java と同様に readline して１行ごとに Scanner を作っても書けますが，
		 ここでは，シンプルに，BufferedReader に Scanner をかけます。 */
		try(Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));){
//			sc.useDelimiter("[\\P{InCJKUnifiedIdeographs}]+");
			sc.useDelimiter("[\\P{InKatakana}]+");
			while(sc.hasNext()){
				String s = sc.next();
				Integer d = hm.get(s);
				if(d == null){
				    hm.put(s, 1);
				}else{
				    hm.put(s, d+1);
				}
			}
		}catch(IOException e){System.out.println(e.getMessage());}
	}
}
