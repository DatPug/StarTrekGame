
import java.io.IOException;
import java.util.Scanner;

public class Game {

	public static void main(String[] ships) throws IOException, InterruptedException {
		
		OnePlayerTurn opt = new OnePlayerTurn();
		TwoPlayerTurn tpt = new TwoPlayerTurn();
		ChooseShips choose = new ChooseShips();
		
		choose.chooseShips(); 
		
		if (choose.isAi() == false)  { // determines which class is used.
			tpt.twoPlayerTurn(ships, ships, ships);
		} else if (choose.isAi() == true) {
			opt.onePlayerTurn(ships, ships);
		}
		 System.out.println("\nPress enter to close");
		 @SuppressWarnings("resource")
		Scanner pause = new Scanner(System.in); 
		 pause.nextLine();
	}
}
