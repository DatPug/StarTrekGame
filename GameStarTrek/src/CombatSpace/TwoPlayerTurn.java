package CombatSpace;

import java.io.IOException;

public class TwoPlayerTurn {

	void twoPlayerTurn(Object ff, Object kf) throws IOException {

		
		ff = ChooseShips.x; // calls x from ChooseShips and sets to ff
		kf = ChooseShips.y; // calls y from ChooseShips and sets to kf
		boolean gameEnded = false;
		int counter = (int) Math.random() * 2;

		while (!gameEnded) {
			if (counter % 2 == 0) {
				
				OnePlayerTurn.fed = false;
				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).gethullStrength() <= 0) {
					System.out.println("The KDF " + ChooseShips.getkName() + " was victorious!");
					break;
					// if federation ship goes to 0 hull, break out of loop
				}

				OnePlayerTurn.fed = true;
				((FederationFleet) ff).choose(ff, kf);
				

				if (((KlingonFleet) kf).gethullStrength() <= 0) {
					System.out.println("The USS " + ChooseShips.getfName() + " was victorious!");
					break;
					// if Klingon ship goes to 0 hull, break out of loop
				}
			}

			else {
				OnePlayerTurn.fed = true;
				((FederationFleet) ff).choose(ff, kf);

				if (((KlingonFleet) kf).gethullStrength() <= 0) {
					System.out.println("The USS " + ChooseShips.getfName() + " was victorious!");
					break;
					// if Klingon ship goes to 0 hull, break out of loop
				}
				OnePlayerTurn.fed = false;

				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).gethullStrength() <= 0) {
					System.out.println("The KDF " + ChooseShips.getkName() + " was victorious!");
					break;
					// if federation ship goes to 0 hull, break out of loop
				}
			}
		}
	}
}
