package chap03;

public class Sum34 {
    public static void main(String[] args){
        int sum = 0; 
        int i = 0;
        while(sum < 1000){
            i++; 
            sum += i * i;
        }
        System.out.println(i);
    }
}
