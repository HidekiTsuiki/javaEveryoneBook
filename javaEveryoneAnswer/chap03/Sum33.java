package chap03;

public class Sum33 {
    public static void main(String[] args){
        int sum = 0; 
        for(int i = 1; i <= 21; i+=2){
            sum += i;
            System.out.println(sum);
        }
    }
}
