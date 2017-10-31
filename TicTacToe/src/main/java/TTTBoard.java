import java.util.HashSet;
import java.util.Set;

public class TTTBoard {
	private int size;
	private TTTPlayer[][] squares;
	
	public TTTBoard(int size){
		this.size = size;
		squares = new TTTPlayer[size][size];
	}
	
	public TTTBoard addMark(TTTPlayer m, TTTPosition pos){
		TTTBoard newBoard = new TTTBoard(size);
		int row = pos.getRow();
		int column = pos.getColumn();
		for (int i = 0; i<size; i++){
			for (int j = 0; j<size; j++){
				if (i == row && j == column){
					newBoard.squares[i][j] = m;
				}
				else {
					newBoard.squares[i][j] = squares[i][j];
				}
			}
		}
		return newBoard;
	}
	
	public TTTPlayer existsWinner(){
		for (int i = 0; i<size; i++){
			TTTPlayer currentMark = null;
			found: {
				for (int j = 0; j<size; j++){
					if (squares[i][j]==currentMark ^ currentMark!=null) break found;
					currentMark = squares[i][j];
				}
				return currentMark;
			}
		}
		for (int j = 0; j<size; j++){
			TTTPlayer currentMark = null;
			found: {
				for (int i = 0; i<size; i++){
					if (squares[i][j]==currentMark ^ currentMark!=null) break found;
					currentMark = squares[i][j];
				}
				return currentMark;
			}
		}
		found: {
			TTTPlayer currentMark = null;
			for (int i = 0; i<size; i++){
				if (squares[i][i]==currentMark ^ currentMark!=null) break found;
				currentMark = squares[i][i];
			}
			return currentMark;
		}
		found: {
			TTTPlayer currentMark = null;
			for (int i = 0; i<size; i++){
				if (squares[i][size-i-1]==currentMark ^ currentMark!=null) break found;
				currentMark = squares[i][size-i-1];
			}
			return currentMark;
		}
		return null;
	}
	
	public boolean isFull(){
		for (int i = 0; i<size; i++){
			for (int j = 0; j<size; j++){
				if (squares[i][j] == null) return false;
			}
		}
		return true;
	}
	
	public boolean isValidMove(TTTPosition pos){
		return squares[pos.getRow()][pos.getColumn()]==null;
	}
	
	public int getSize(){
		return size;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<size; i++){
			for (int j = 0; j<size; j++){
				TTTPlayer square = squares[i][j];
				if (square == null){
					sb.append(" ");
				}
				else{
					sb.append(square.toString());
				}
				sb.append(' ');
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public TTTPlayer getMark(TTTPosition pos){
		return squares[pos.getRow()][pos.getColumn()];
	}
	
	public Set<TTTPlayer> marks(){
		Set<TTTPlayer> marks = new HashSet<TTTPlayer>();
		for (int i = 0; i<size; i++){
			for (int j = 0; j<size; j++){
				TTTPlayer m = squares[i][j];
				if (m!=null) marks.add(m);
			}
		}
		
		return marks;
	}
}
