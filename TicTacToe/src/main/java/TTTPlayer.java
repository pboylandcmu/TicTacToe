
public class TTTPlayer {
	private final TTTMark myMark;
	private final TTTStrategy strat;
	
	public TTTPlayer(TTTMark mark, TTTStrategy strategy){
		myMark = mark;
		strat = strategy;
	}
	
	public TTTMark getMark(){
		return myMark;
	}
	
	public TTTStrategy getStrategy(){
		return strat;
	}
}
