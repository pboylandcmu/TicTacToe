import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
	private TTTBoard board;
	private static final int DEFAULT_SIZE = 3;
	private List<TTTPlayer> players;
	private int currentPlayerIdx = 0;
	
	public TicTacToe(){
		board = new TTTBoard(DEFAULT_SIZE);
		players = new ArrayList<TTTPlayer>();
	}
	
	public TicTacToe(int size){
		if (size>0) board = new TTTBoard(size);
		players = new ArrayList<TTTPlayer>();
	}
	
	public void addPlayer(TTTPlayer p){
		players.add(p);
	}
	
	private TTTPlayer getCurrentPlayer(){
		return players.get(currentPlayerIdx);
	}
	
	private void nextPlayer(){
		currentPlayerIdx++;
		currentPlayerIdx %= players.size();
	}
	
	public TTTPlayer runGame(){
		while(!board.isFull()){
			if (board.gameOver()!=null){
				for (TTTPlayer p : players){
					if (board.gameOver().equals(p.getMark())) return p;
				}
				throw new RuntimeException("Unclaimed mark exception");
			}
			TTTPlayer cur = getCurrentPlayer();
			board = board.addMark(cur.getMark(), cur.getStrategy().chooseMove(board,cur.getMark()));
			//System.out.println(board.toString());
			nextPlayer();
			if (board.gameOver()!=null){
				for (TTTPlayer p : players){
					if (board.gameOver().equals(p.getMark())) return p;
				}
				throw new RuntimeException("Unclaimed mark exception");
			}
		}
		return null;
	}
}
