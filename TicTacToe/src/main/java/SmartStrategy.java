import java.util.Random;
import java.util.Set;

public class SmartStrategy implements TTTStrategy{

	@Override
	public TTTPosition chooseMove(TTTBoard b, TTTPlayer myMark) {
		int size = b.getSize();
		
		TTTPosition bestDefense = null;
		Set<TTTPlayer> enemies = b.marks();
		enemies.remove(myMark);
		
		for (int i = 0; i<size; i++){
			for (int j = 0; j<size; j++){
				TTTPosition curPos = new TTTPosition(i,j);
				if (!b.isValidMove(curPos)) break;
				if (myMark.equals(b.addMark(myMark, curPos).existsWinner())) return curPos;
				for (TTTPlayer t : enemies){
					if (t.equals(b.addMark(t, curPos).existsWinner())) bestDefense = curPos;
				}
			}
		}
		if (bestDefense != null) return bestDefense;
		return chooseRandomly(b,size);
	}
	
	public TTTPosition chooseRandomly(TTTBoard b, int size){
		Random a = new Random();
		int randRow = a.nextInt(size);
		int randCol = a.nextInt(size);
		while(!b.isValidMove(new TTTPosition(randRow,randCol))){
			randRow = a.nextInt(size);
			randCol = a.nextInt(size);
		}
		return new TTTPosition(randRow,randCol);
	}
	
	
}
