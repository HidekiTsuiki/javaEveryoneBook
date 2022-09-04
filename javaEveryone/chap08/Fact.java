package chap08;
public class Fact {
	public static void main(String[] argc){
		System.out.println(iterationFact(5));
		System.out.println(recFact(5));
	}
	static int iterationFact(int n){
		int z = 1;
		for(int i = 1; i <= n; i++){
			z = z * i;
		}
		return z;
	}
	static int recFact(int n){
		if(n == 1) return 1;
		return n*recFact(n-1);
	}
}
