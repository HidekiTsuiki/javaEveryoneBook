package chap06;
import java.util.Arrays;

public class Thirteen {
    public static void main(String[] args) {
        int[] count = new int[7];
        for(int y = 1900; y < 2300; y++){
            Calendar c = new Calendar(y);
            for(int m = 1; m <= 12; m++){
                count[c.wday(m, 13)]++;
            }
        }
        System.out.println(Arrays.toString(count));
    }
}
