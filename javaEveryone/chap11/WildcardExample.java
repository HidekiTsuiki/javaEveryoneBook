package chap11;
import java.util.List;

public class WildcardExample {
	static <E> E first(List<E> list){
		return list.get(0);
	}
	static int doublesize(List<?> list){
		return list.size()*2;
	}
}
