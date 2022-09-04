package math;

public class Newton {
    public static double newton(double r){
        double x = 1;
        while(true){
            double x2 =  x - (x*x - r) / (x * 2);
            if(Math.abs(x2 - x) < 0.00001) return x;
            x = x2;
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(i + " : " + newton(i));
        }
    }

}
