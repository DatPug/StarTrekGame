
import java.io.IOException;

public class OnePlayerTurn {
	static boolean fed = false;
	static boolean kling = false;
	
	
	public static void onePlayerTurn(Object ff, Object kf) throws IOException, InterruptedException {

		if (ChooseShips.fed == true) {
			ff = ChooseShips.x; // calls x from ChooseShips and sets to ff
			kf = ChooseShips.y; // calls y from ChooseShips and sets to kf
		}

		if (ChooseShips.kling == true) {
			ff = ChooseShips.y;
			kf = ChooseShips.x;
		}

		boolean gameEnded = false;

		if (ChooseShips.fed == true) {
			while (!gameEnded) { // while game isnt ended
				
				fed = true;
				((FederationFleet) ff).choose(ff, kf);
				

				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The USS " + ChooseShips.fName + " was victorious!");
					break;
					// if the Klingon ship goes to 0 hull, break out of loop
				}
				fed = false;
				kling = true;
				((KlingonFleet) kf).attackMenu(ff, kf);
				Ai.aiChoiceKling(ff, kf);
				kling = false;
				
				

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
				}
			}
		}

		if (ChooseShips.kling == true) {
			while (!gameEnded) {
				
				kling = true;
				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).getHullStrengthA() <= 0) {
					System.out.println("The KDF " + ChooseShips.kName + " was victorious!");
					break;
					// if the Klingon ship goes to 0 hull, break out of loop
				}
				kling = false;
				fed = true;
				((FederationFleet) ff).attackMenu(ff, kf);
				Ai.aiChoiceFed(ff, kf);
				fed = false;

				if (((KlingonFleet) kf).getHullStrengthA() <= 0) {
					System.out.println("The USS " + ChooseShips.fName + " was victorious!");
					break;
				}
			}
		}
	}
}
