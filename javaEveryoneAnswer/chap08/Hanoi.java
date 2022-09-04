package chap08;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(2, "A", "B", "C");
    }
    static void hanoi(int n, String from, String to, String via){
        if(n > 0){
            hanoi(n-1, from, via, to);
            System.out.println("円盤"+n+"を棒"+from+"から棒"+to+"に移動。");
            hanoi(n-1, via, to, from);
        }
    }
}
