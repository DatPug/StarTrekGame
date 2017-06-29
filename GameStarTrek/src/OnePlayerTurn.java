

import java.io.IOException;

public class OnePlayerTurn {


	public static void onePlayerTurn() throws IOException, InterruptedException {

		Object ff = ChooseShips.x; // calls x from ChooseShips and sets to ff
		Object kf = Ai.y; // calls y from ChooseShips and sets to kf
		boolean gameEnded = false;
		
		while (!gameEnded) {

			((FederationFleet) ff).choose(ff, kf);

			if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
				System.out.println("The USS " + ChooseShips.fName + " was victorious!");
				break;
				// if the Klingon ship goes to 0 hull, break out of loop
			}

			((KlingonFleet) kf).attackMenu(ff, kf);
			Ai.aiChoose(ff, kf);

			if (((FederationFleet) ff).getHullStrengthA() <= 0) {
				System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
				break;
			}
		}
	}
}
