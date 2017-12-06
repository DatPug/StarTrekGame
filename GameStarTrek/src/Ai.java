
import java.util.Random;

public class Ai {

	public static Object kling;
	public static Object fed;
	public static String kName;
	public static String fName;

	public static void aiChooseFed() {

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

	public static void aiChooseKling() {

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
			System.out.println("Computer chose: The KDF " + Ai.kName);
			System.out.println("Ship type: Well-Rounded \n");
			ChooseShips.y = kling;
			break;
		// stores selection in y
		case 3:
			kling = KlingonFleet.c;
			kName = "Qolen";
			System.out.println();
			System.out.println("Computer chose: The KDF " + Ai.kName);
			System.out.println("Ship type: Defensive \n");
			ChooseShips.y = kling;
			break;
		// stores selection in y
		}
	}

	public static void aiChoiceKling(Object ff, Object kf) {
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

			if (ChooseShips.ai == true && ((KlingonFleet) kf).gethNum() < 0
					&& ((KlingonFleet) kf).getHullStrengthA() <= 20) {

				Commands.defence2(ff, kf);
			} else if (((KlingonFleet) kf).getHullStrengthA() < 75) {
				if (((KlingonFleet) kf).gethNum() > 0) {
					Commands.defence2(ff, kf);
				} else
					aiChoiceKling(ff, kf);
			} else if (((KlingonFleet) kf).getHullStrengthA() > 75) {
				aiChoiceKling(ff, kf);
			}
			break;
		}
	}

	public static void aiChoiceFed(Object ff, Object kf) {
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
			if (ChooseShips.ai == true && ((FederationFleet) ff).gethNum() < 0
			&& ((FederationFleet) ff).getHullStrengthA() <= 20) {

				Commands.defence2(ff, kf);
			}
			if (((FederationFleet) ff).getHullStrengthA() < 50) {
				if (((FederationFleet) ff).gethNum() > 0) {
					Commands.defence2(ff, kf);
				} else
					aiChoiceFed(ff, kf);
			} else if (((FederationFleet) ff).getHullStrengthA() > 50) {
				aiChoiceFed(ff, kf);
			}
			break;
		}
	}
}
