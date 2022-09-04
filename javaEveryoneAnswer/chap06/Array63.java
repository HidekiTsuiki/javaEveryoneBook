package chap06;
import java.util.Arrays;

public class Array63 {
	public static void main(String[] args){
		int[]  data= {100,50,200,100,0,200,102,40,30,100};
		show(data);
		System.out.println("合計：" + sum(data));
		System.out.println("最大値：" + max(data));
		System.out.println("maxIndex は拡張された for 文で書けない。");
		System.out.println("100 以上の個数：" + numGreater(data,100));
// 練習問題 6.14 で追加
		arraysmethods(data);
	}

	static void show(int... a){
		for(int n:a){
			System.out.print(n + ", ");
		}
		System.out.println("");
	}   	
	static int sum(int[] a){ 
		int sum = 0;
		for(int n:a){
			sum += n;
		}
		return sum;
	}
	static int max(int[] a){
		int max = a[0];
		for(int n:a){
			if (n > max) max = n;
		}
		return max;
	}
	static int numGreater(int[] a, int n){
		int c = 0;
		for(int i:a){
			if (i >= n) c++;
		}
		return c;
	}
    public static void arraysmethods(int[] a){      
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        binarySearchOutput(a, 100);
        binarySearchOutput(a, 101);
    }
    public static void binarySearchOutput(int[] a, int n){          
        int k = Arrays.binarySearch(a,  n);
        if(k >= 0){
            System.out.println(n+"は，"+k+"番目の要素です。");
        }else{
            System.out.println(n+"は，"+(-k-2)+"番目と"+(-k-1)+"番目の間です。");
        }
    }
}
