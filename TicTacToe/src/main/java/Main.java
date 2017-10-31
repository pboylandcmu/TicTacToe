
public class Main {

	public static void main(String[] args) {
		TicTacToe game;
		TTTStrategy dumb = new DumbStrategy();
		TTTStrategy smart = new SmartStrategy();
		TTTPlayer player1 = new TTTPlayer(TTTMark.getMark("X"), dumb);
		TTTPlayer player2 = new TTTPlayer(TTTMark.getMark("O"), smart);
		TTTPlayer player3 = new TTTPlayer(TTTMark.getMark("T"), dumb);

		int firstWins = 0;
		int ties = 0;
		int secondWins = 0;
		for (int i = 0; i<1_000_000; i++){
			game = new TicTacToe(3); 
			game.addPlayer(player1);
			game.addPlayer(player2);
			TTTPlayer result = game.runGame();
			if (result == null) ties++;
			else{
				String winner = result.getMark().toString();
				if (winner.equals("X")) firstWins++;
				if (winner.equals("O")) secondWins++;
			}
		}
		System.out.println(String.valueOf(firstWins) + "/" + String.valueOf(secondWins) + "/" + String.valueOf(ties));
	}

}
