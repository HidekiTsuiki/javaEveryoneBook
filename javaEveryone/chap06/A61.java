package chap06;


public class A61 {
    public static void main(String[] args){
        int[] a = new int[5];
        a[0] = 0; a[1] = 31; a[2] = 28; a[3] = 31; a[4] = 30;
        int sum = 0;
        for(int i = 0 ; i < 5; i++){
            sum += a[i];
        } 
        System.out.println(sum);
    }
}      
