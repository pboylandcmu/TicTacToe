import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class TTTBoard {
	private int size;
	private TTTPlayer[][] squares;
	private List<List<TTTPosition>> winningLines;
	
	public TTTBoard(int size){
		this.size = size;
		squares = new TTTPlayer[size][size];
		winningLines = new ArrayList<List<TTTPosition>>();
		initializeLines();
	}
	
	private void initializeLines(){
		for (int i = 0; i<size; i++){
			List<TTTPosition> curRow = new ArrayList<TTTPosition>();
			for (int j = 0; j<size; j++){
				curRow.add(new TTTPosition(i,j));
			}
			winningLines.add(curRow);
		}
		
		for (int i = 0; i<size; i++){
			List<TTTPosition> curCol = new ArrayList<TTTPosition>();
			for (int j = 0; j<size; j++){
				curCol.add(new TTTPosition(j,i));
			}
			winningLines.add(curCol);
		}
		List<TTTPosition> leftDiagonal = new ArrayList<TTTPosition>();
		List<TTTPosition> rightDiagonal = new ArrayList<TTTPosition>();
		for (int i = 0; i<size; i++){
			leftDiagonal.add(new TTTPosition(i,i));
			rightDiagonal.add(new TTTPosition(i,size-i-1));
		}
		winningLines.add(leftDiagonal);
		winningLines.add(rightDiagonal);
	}
	
	public TTTBoard addMark(TTTPlayer m, TTTPosition pos){
		if (!isValidMove(pos)) throw new RuntimeException("tried to play invalid move");
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
		for (List<TTTPosition> line : winningLines){
			TTTPlayer currentMark = getMark(line.get(0));
			found : {
				for (int i = 1; i<size; i++){
					TTTPlayer occupier = getMark(line.get(i));
					if (currentMark!=occupier) break found;
					currentMark = occupier;
				}
				return currentMark;
			}
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
