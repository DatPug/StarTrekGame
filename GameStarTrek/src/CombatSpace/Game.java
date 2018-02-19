package CombatSpace;

import java.io.IOException;
import java.util.Scanner;

public class Game {

	public static void main(String[] ships) throws IOException, InterruptedException {

		OnePlayerTurn opt = new OnePlayerTurn();
		TwoPlayerTurn tpt = new TwoPlayerTurn();
		ChooseShips choose = new ChooseShips();
		Game game = new Game();

		choose.chooseShips();

		if (choose.isAi() == false) { // do if no Ai selected.
			tpt.twoPlayerTurn(ships, ships);
		} else if (choose.isAi() == true) { // do if Ai selected.
			opt.onePlayerTurn(ships, ships);
		}

		game.pause();
	}

	private void pause() {
		System.out.println("\nPress enter to close");
		@SuppressWarnings("resource")
		Scanner pause = new Scanner(System.in);
		pause.nextLine();
		
 	} 
}
