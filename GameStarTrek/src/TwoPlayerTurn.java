

import java.io.IOException;

public class TwoPlayerTurn {

	public static void twoPlayerTurn() throws IOException {

		Object ff = ChooseShips.x; // calls x from ChooseShips and sets to ff
		Object kf = ChooseShips.y; // calls y from ChooseShips and sets to kf
		boolean gameEnded = false;
		int counter = (int) Math.random() * 2;

		while (!gameEnded) {
			if (counter % 2 == 0) {
				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
					// if federation ship goes to 0 hull, break out of loop
				}

				((FederationFleet) ff).choose(ff, kf);

				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The USS " + ChooseShips.fName + " was victorious!");
					break;
					// if Klingon ship goes to 0 hull, break out of loop
				}
			}

			else {
				((FederationFleet) ff).choose(ff, kf);

				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The USS " + ChooseShips.fName + " was victorious!");
					break;
					// if Klingon ship goes to 0 hull, break out of loop
				}
				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
					// if federation ship goes to 0 hull, break out of loop
				}
			}
		}
	}
}
