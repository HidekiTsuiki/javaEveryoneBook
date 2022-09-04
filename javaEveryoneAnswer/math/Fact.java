package math;

public class Fact {
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++){
            System.out.println(i + ": " + fact(i));
        }
    }
    static int fact(int n){
        int r = 1;
        for(int i = 1; i <= n; i++){
            r *= i;   // r = r * i; と同じです
        }
        return r;
    }
}

