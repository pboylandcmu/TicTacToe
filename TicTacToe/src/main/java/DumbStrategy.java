import java.util.Random;

public class DumbStrategy implements TTTStrategy {

	@Override
	public TTTPosition chooseMove(TTTBoard b, TTTPlayer m) {
		int size = b.getSize();
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
