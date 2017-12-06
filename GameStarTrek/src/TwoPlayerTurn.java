
import java.io.IOException;

public class TwoPlayerTurn {

	public static void twoPlayerTurn(Object ff, Object kf, Object rf) throws IOException {

		ff = ChooseShips.x; // calls x from ChooseShips and sets to ff
		kf = ChooseShips.y; // calls y from ChooseShips and sets to kf
		boolean gameEnded = false;
		int counter = (int) Math.random() * 2;

		while (!gameEnded) {
			if (counter % 2 == 0) {
				OnePlayerTurn.kling = true;
				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
					// if federation ship goes to 0 hull, break out of loop
				}

				OnePlayerTurn.kling = false;
				OnePlayerTurn.fed = true;
				((FederationFleet) ff).choose(ff, kf);
				OnePlayerTurn.fed = false;
				
				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The USS " + ChooseShips.fName + " was victorious!");
					break;
					// if Klingon ship goes to 0 hull, break out of loop
				}
			}

			else {
				OnePlayerTurn.fed = true;
				((FederationFleet) ff).choose(ff, kf);

				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The USS " + ChooseShips.fName + " was victorious!");
					break;
					// if Klingon ship goes to 0 hull, break out of loop
				}
				OnePlayerTurn.fed = false;
				OnePlayerTurn.kling = true;
				((KlingonFleet) kf).choose(ff, kf);
				OnePlayerTurn.kling = false;

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
					// if federation ship goes to 0 hull, break out of loop
				}
			}
		}
	}
}
