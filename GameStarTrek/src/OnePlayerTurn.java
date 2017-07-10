
import java.io.IOException;

public class OnePlayerTurn {

	public static void onePlayerTurn(Object ff, Object kf) throws IOException, InterruptedException {

		if (ChooseShips.fed == true) {
			ff = ChooseShips.x; // calls x from ChooseShips and sets to ff
			kf = Ai.kling; // calls y from ChooseShips and sets to kf
		}

		if (ChooseShips.kling == true) {
			ff = Ai.fed;
			kf = ChooseShips.y;
		}

		boolean gameEnded = false;

		if (ChooseShips.fed == true) {
			while (!gameEnded) {

				((FederationFleet) ff).choose(ff, kf);

				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The USS " + ChooseShips.fName + " was victorious!");
					break;
					// if the Klingon ship goes to 0 hull, break out of loop
				}

				((KlingonFleet) kf).attackMenu(ff, kf);
				Ai.aiChoiceKling(ff, kf);

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
				}
			}
		}

		if (ChooseShips.kling == true) {
			while (!gameEnded) {

				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
					// if the Klingon ship goes to 0 hull, break out of loop
				}

				((FederationFleet) ff).attackMenu(ff, kf);
				Ai.aiChoiceFed(ff, kf);

				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
				}
			}
		}
	}
}
