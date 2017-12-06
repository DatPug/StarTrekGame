
import java.io.IOException;
import java.util.Scanner;

public class Game {

	public static void main(String[] ships) throws IOException, InterruptedException {

		ChooseShips.chooseShips(); 
		if (ChooseShips.ai == false)  { // determines which class is used.
			TwoPlayerTurn.twoPlayerTurn(ships, ships, ships);
		} else if (ChooseShips.ai == true) {
			OnePlayerTurn.onePlayerTurn(ships, ships);
		}
		 System.out.println("\nPress enter to close");
		 Scanner pause = new Scanner(System.in); 
		 pause.nextLine();
	}
}
