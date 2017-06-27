


import java.io.IOException;

public class Game {

	public static void main(String[] args) throws IOException, InterruptedException {

		ChooseShips.chooseShips();
		if (ChooseShips.ai == false) {
			TwoPlayerTurn.twoPlayerTurn();
		} else if (ChooseShips.ai == true) {
			OnePlayerTurn.onePlayerTurn();
		}

	}
}
