import java.util.HashMap;
import java.util.Map;

public class TTTMark {
	private String mark;
	private static Map<String,TTTMark> marks;
	
	private TTTMark(String symbol){
		mark = symbol;
	}
	
	public String toString(){
		return mark;
	}
	
	public static TTTMark getMark(String s){
		if (marks == null) marks = new HashMap<String,TTTMark>();
		if (!marks.containsKey(s)) marks.put(s, new TTTMark(s));
		return marks.get(s);
	}	
}
