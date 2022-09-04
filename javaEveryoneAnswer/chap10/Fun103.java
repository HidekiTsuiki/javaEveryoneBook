package chap10;

public class Fun103{
    public static void main(String[] args){
        UnitFun fun = x -> 3.5 * x * (1-x);
        System.out.println(fun.apply(0.5));   
    }
}
