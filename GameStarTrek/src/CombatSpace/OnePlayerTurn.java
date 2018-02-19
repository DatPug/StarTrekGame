package CombatSpace;

import java.io.IOException;

public class OnePlayerTurn {
	
	static boolean fed;
	static boolean kling;
	static boolean rom;
	
	void onePlayerTurn(Object ff, Object kf) throws IOException, InterruptedException {
		Ai classAi = new Ai();
		
		if (ChooseShips.fed == true) {
			
			ff = ChooseShips.x; // calls x from ChooseShips and sets to ff
			kf = ChooseShips.y; // calls y from ChooseShips and sets to kf
			
		}

		if (ChooseShips.kling == true) {
			
			kf = ChooseShips.x;
			ff = ChooseShips.y;
			
		}
		
//		if(ChooseShips.rom == true) {
//			double ai = Math.random();
//			rf = ChooseShips.x;
//			if(ai > .5)
//			kf = ChooseShips.y;
//			else
//			ff = ChooseShips.y;
//			
//		}

		boolean gameEnded = false;

		if (ChooseShips.fed == true) {
			while (!gameEnded) { // while game isnt ended

				fed = true;
				((FederationFleet) ff).choose(ff, kf);

				if (((KlingonFleet) kf).gethullStrength() <= 0) {
					System.out.println("The USS " + ChooseShips.getfName() + " was victorious!");
					break;
					// if the Klingon ship goes to 0 hull, break out of loop
				}
				fed = false;

				((KlingonFleet) kf).attackMenu(ff, kf);
				classAi.aiChoiceKling(ff, kf);

				if (((FederationFleet) ff).gethullStrength() <= 0) {
					System.out.println("The KDF " + ChooseShips.getkName() + " was victorious!");
					break;
				}
			}
		}

		if (ChooseShips.kling == true) {
			while (!gameEnded) {

				fed = false;
				((KlingonFleet) kf).choose(ff, kf);

				if (((FederationFleet) ff).gethullStrength() <= 0) {
					System.out.println("The KDF " + ChooseShips.getkName() + " was victorious!");
					break;
					// if the Klingon ship goes to 0 hull, break out of loop
				}

				fed = true;
				((FederationFleet) ff).attackMenu(ff, kf);
				classAi.aiChoiceFed(ff, kf);

				if (((KlingonFleet) kf).gethullStrength() <= 0) {
					System.out.println("The USS " + ChooseShips.getfName() + " was victorious!");
					break;
				}
			}
		}
	}
}
