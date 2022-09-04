package chap10;

public class Fun101{
    public static void main(String[] args){
        UnitFun f = (double x) -> {
            return x * x;
        };
        System.out.println(f.apply(0.5));   
    }
}
