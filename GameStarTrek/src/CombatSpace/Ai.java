package CombatSpace;

import java.util.Random;

public class Ai {

	Object kling;
	Object fed;
	Object rom;
	String kName;
	String fName;
	String rName;

	public  void aiChooseFed() {

		Random x = new Random();
		int choice = 1 + x.nextInt(3);

		switch (choice) {
		case 1:
			fed = FederationFleet.b;
			fName = "Excelsior";
			System.out.println();
			System.out.println("Computer chose: The USS " + fName);
			System.out.println("Ship type: Offensive \n");
			ChooseShips.y = fed;
			break;
		case 2:
			fed = FederationFleet.a;
			fName = "Mississippi";
			System.out.println();
			System.out.println("Computer chose: The USS " + fName);
			System.out.println("Ship type: Well-Rounded \n");
			ChooseShips.y = fed;
			break;
		case 3:
			fed = FederationFleet.c;
			fName = "Phoenix";
			System.out.println();
			System.out.println("Computer chose: The USS " + fName);
			System.out.println("Ship type: Defensive \n");
			ChooseShips.y = fed;
			break;
		}
	}

	public void aiChooseKling() {

		Random x = new Random();
		int choice = 1 + x.nextInt(3);

		switch (choice) {
		case 1:
			kling = KlingonFleet.b;
			kName = "Ke'noq";
			System.out.println();
			System.out.println("Computer chose: The KDF " + kName);
			System.out.println("Ship type: Offensive \n");
			ChooseShips.y = kling;
			break;
		// stores selection in y
		case 2:
			kling = KlingonFleet.a;
			kName = "Ye'nak";
			System.out.println();
			System.out.println("Computer chose: The KDF " + kName);
			System.out.println("Ship type: Well-Rounded \n");
			ChooseShips.y = kling;
			break;
		// stores selection in y
		case 3:
			kling = KlingonFleet.c;
			kName = "Qolen";
			System.out.println();
			System.out.println("Computer chose: The KDF " + kName);
			System.out.println("Ship type: Defensive \n");
			ChooseShips.y = kling;
			break;
		// stores selection in y
		}
	}
	
	public void aiChooseRom() {
		
		Random x = new Random();
		int choice = 1 + x.nextInt(3);
		
		switch(choice) {
		case 1:
			rom = RomulanFleet.b;
			rName = "";
			System.out.println();
			System.out.println("Computer chose: RSE " + rName);
			System.out.println("Ship type: Offensive \n");
			ChooseShips.y = rom;
			break;
			//stores selection in z
		case 2:
			rom = RomulanFleet.a;
			rName = "";
			System.out.println();
			System.out.println("Computer chose: RSE " + rName);
			System.out.println("Ship type: Well-Rounded");
			ChooseShips.y = rom;
			break;
			//stores choice in y
		case 3:
			rom = RomulanFleet.c;
			rName = "vas'Deletham";
			System.out.println();
			System.out.println("Computer chose: RSE " + rName);
			ChooseShips.y = rom;
			break;
		}
		
	}

	public void aiChoiceKling(Object ff, Object kf) {
		ChooseShips choose = new ChooseShips();
		Random x = new Random();
		int choice = 1 + x.nextInt(4);

		switch (choice) {
		case 1:
			Commands.attack1(ff, kf);
			break;
		case 2:
			if (((KlingonFleet) kf).gettNum() > 0) {
				Commands.attack2(ff, kf);
			} else if (((KlingonFleet) kf).gettNum() == 0) {
				aiChoiceKling(ff, kf);
			}
			break;
		case 3:
			if (((KlingonFleet) kf).getShieldStrength() == 0) {
				if (((KlingonFleet) kf).getrNum() > 0) {
					Commands.defence1(ff, kf);
				} else
					aiChoiceKling(ff, kf);
			} else if (((KlingonFleet) kf).getShieldStrength() > 0) {
				aiChoiceKling(ff, kf);
			}
			break;
		case 4:

			if (choose.isAi() == true && ((KlingonFleet) kf).gethNum() < 0
					&& ((KlingonFleet) kf).gethullStrength() <= 20) {

				Commands.defence2(ff, kf);
			} else if (((KlingonFleet) kf).gethullStrength() < 75) {
				if (((KlingonFleet) kf).gethNum() > 0) {
					Commands.defence2(ff, kf);
				} else
					aiChoiceKling(ff, kf);
			} else if (((KlingonFleet) kf).gethullStrength() > 75) {
				aiChoiceKling(ff, kf);
			}
			break;
		}
	}

	public void aiChoiceFed(Object ff, Object kf) {
		ChooseShips choose = new ChooseShips();
		Random x = new Random();
		int choice = 1 + x.nextInt(4);

		switch (choice) {
		case 1:
			Commands.attack1(ff, kf);
			break;
		case 2:
			if (((FederationFleet) ff).gettNum() > 0) {
				Commands.attack2(ff, kf);
			} else if (((FederationFleet) ff).gettNum() == 0) {
				aiChoiceFed(ff, kf);
			}
			break;
		case 3:
			if (((FederationFleet) ff).getShieldStrength() == 0) {
				if (((FederationFleet) ff).getrNum() > 0) {
					Commands.defence1(ff, kf);
				} else
					aiChoiceFed(ff, kf);
			} else if (((FederationFleet) ff).getShieldStrength() > 0) {
				aiChoiceKling(ff, kf);
			}
			break;
		case 4:
			if (choose.isAi() == true && ((FederationFleet) ff).gethNum() < 0
			&& ((FederationFleet) ff).gethullStrength() <= 20) {

				Commands.defence2(ff, kf);
			}
			if (((FederationFleet) ff).gethullStrength() < 50) {
				if (((FederationFleet) ff).gethNum() > 0) {
					Commands.defence2(ff, kf);
				} else
					aiChoiceFed(ff, kf);
			} else if (((FederationFleet) ff).gethullStrength() > 50) {
				aiChoiceFed(ff, kf);
			}
			break;
		}
	}
}
