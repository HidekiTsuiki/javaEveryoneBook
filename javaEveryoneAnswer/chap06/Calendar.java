package chap06;
public class Calendar {
	int gantan;
    int[] mon = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    String[] week = {"日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日"};  // 練習問題 7.6
    public static void main(String[] args){
        Calendar c;
        int year = 2017;
        if(args.length > 0){  // 練習問題 6.17 で追加
             year = Integer.parseInt(args[0]);
            c = new Calendar(year); 
        }else{
            c = new Calendar(0,  false);  // 2017 年の場合，１月１日は日曜日で閏年ではない
        }
        System.out.println("4 月 1 日は" + c.wday(4, 1));
        System.out.print("すなわち");
        c.showWday(4,1);
        System.out.println("4 月のカレンダー");
        c.showCalendar(4);
        System.out.println(year + "年のカレンダー");
        c.showCalendar();
	}
   
    Calendar(int gantan, boolean leap){
		this.gantan = gantan;
		if(leap) mon[2]=29;
	}	
    int numdays(int m, int d){
    	  	int sum = 0;
    	  	for(int i = 1; i < m; i++){
    	  		sum += mon[i];
    	  	}
    	  	sum += d;
    	  	return sum;
    }
    int wday(int m, int d){
    	   return (numdays(m,d) - 1 + gantan) % 7;
    }
    void showWday(int m, int d){
    	   System.out.println(week[wday(m,d)]);
    }
    void showCalendar(int m){
        int k = wday(m, 1);
        for(int i = 0; i < k; i++) System.out.print("   ");
        for(int i = 1; i <= mon[m]; i++){
            System.out.format("%3d", i);
            if(wday(m, i)== 6 && i < mon[m]) System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }
    void showCalendar(){
        for(int m = 1; m < 13; m++){
            System.out.println("         "+m + "月");
            showCalendar(m);
        }
    }
    
    // 練習問題 7.21 で追加
    Calendar(int year){
        int days = 0;
        for(int y = 1900; y < year; y++){
            if(leap(y)){
                days += 366;
            }else{
                days += 365;
            }
        }
        this.gantan = (days + 1) % 7;
        if(leap(year)) mon[2] = 29;
    }
    boolean leap(int y){
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0);
    }
}
