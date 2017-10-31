
public class Main {

	public static void main(String[] args) {
		TicTacToe game;
		TTTStrategy dumb = new DumbStrategy();
		TTTStrategy smart = new SmartStrategy();
		TTTPlayer player1 = TTTPlayer.getPlayer("X", dumb);
		TTTPlayer player2 = TTTPlayer.getPlayer("O", smart);

		int firstWins = 0;
		int ties = 0;
		int secondWins = 0;
		for (int i = 0; i<1; i++){
			game = new TicTacToe(3); 
			game.addPlayer(player1);
			game.addPlayer(player2);
			TTTPlayer result = game.runGame();
			if (result == null) ties++;
			else{
				if (result == player1) firstWins++;
				if (result == player2) secondWins++;
			}
		}
		System.out.println(String.valueOf(firstWins) + "/" + String.valueOf(secondWins) + "/" + String.valueOf(ties));
	}

}
