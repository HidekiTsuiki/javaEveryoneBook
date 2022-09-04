package chap06;
public class Array65 {
    public static void main(String[] args){
        int[][] a = {{2,5,4,2},{2,2,4,1},{1,3,4,2}};
        System.out.println(java.util.Arrays.toString(a));  //toString の実験
        System.out.println(java.util.Arrays.deepToString(a)); //deepToString の実験, 練習問題委 6.14

        show(a);
        rows(a);
        columns(a);
        all(a);
    }
    static void show(int[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    static void rows(int[][] a){
        System.out.print("行の和: ");
        for(int i = 0; i < a.length; i++){
            int sum = 0;
            for(int j = 0; j < a[i].length; j++){
                sum += a[i][j];
            }
            System.out.print(sum + " ");
        }
        System.out.println("");
    }

    static void columns(int[][] a){
        System.out.print("列の和: ");
        for(int j = 0; j < a[0].length; j++){  // 全ての行が同じ個数でないと動かない
            int sum = 0;
            for(int i = 0; i < a.length; i++){
                sum += a[i][j];
            }
            System.out.print(sum + " ");
        }
        System.out.println("");
    }

    static void all(int[][] a){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                sum += a[i][j];
            }
        }
        System.out.println("全体の和: " + sum);
    }
}
