import java.util.HashMap;
import java.util.Map;

public class TTTPlayer {
	private String mark;
	private TTTStrategy strat;
	private static Map<String,TTTPlayer> marks;
	
	private TTTPlayer(String symbol, TTTStrategy strategy){
		mark = symbol;
		strat = strategy;
	}
	
	public String toString(){
		return mark;
	}
	
	public TTTStrategy getStrategy(){
		return strat;
	}
	
	public static TTTPlayer getPlayer(String s, TTTStrategy strat){
		if (marks == null) marks = new HashMap<String,TTTPlayer>();
		if (!marks.containsKey(s)) marks.put(s, new TTTPlayer(s,strat));
		return marks.get(s);
	}
}
