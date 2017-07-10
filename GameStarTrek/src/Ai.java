
import java.util.Random;

public class Ai {

	public static Object kling;
	public static Object fed;
	public static String kName;
	public static String fName;

	public static void aiChooseFed() {

		Random x = new Random();
		int choice = 1 + x.nextInt(3);

		if (ChooseShips.kling == true) {
			if (choice == 1) {
				fed = FederationFleet.b;
				fName = "Excelsior";
				System.out.println();
				System.out.println("Computer chose: The USS " + fName);
				System.out.println("Ship type: Offensive \n");
			}

			if (choice == 2) {
				fed = FederationFleet.a;
				fName = "Mississippi";
				System.out.println();
				System.out.println("Computer chose: The USS " + fName);
				System.out.println("Ship type: Well-Rounded \n");
			}

			if (choice == 3) {
				fed = FederationFleet.c;
				fName = "Phoenix";
				System.out.println();
				System.out.println("Computer chose: The USS " + fName);
				System.out.println("Ship type: Defensive \n");
			}
		}
	}

	public static void aiChooseKling() {

		Random x = new Random();
		int choice = 1 + x.nextInt(3);

		if (ChooseShips.fed == true) {

			if (choice == 1) {
				kling = KlingonFleet.b;
				kName = "Ke'noq";
				System.out.println();
				System.out.println("Computer chose: The KDF " + kName);
				System.out.println("Ship type: Offensive \n");
				// stores selection in y
			}

			if (choice == 2) { 
				kling = KlingonFleet.a;
				kName = "Ye'nak";
				System.out.println();
				System.out.println("Computer chose: The KDF " + Ai.kName);
				System.out.println("Ship type: Well-Rounded \n");
				// stores selection in y
			}

			if (choice == 3) {
				kling = KlingonFleet.c;
				kName = "Qolen";
				System.out.println();
				System.out.println("Computer chose: The KDF " + Ai.kName);
				System.out.println("Ship type: Defensive \n");
				// stores selection in y
			}
		}
	}

	public static void aiChoiceKling(Object ff, Object kf) {
		Random x = new Random();
		int choice = 1 + x.nextInt(4);

		if (choice == 1) {
			((KlingonFleet) kf).attack1(ff, kf);
		} else if (choice == 2) {
			if (((KlingonFleet) kf).gettNum() > 0) {
				((KlingonFleet) kf).attack2(ff, kf);
			} else if (((KlingonFleet) kf).gettNum() == 0) {
				aiChoiceKling(ff, kf);
			}
		} else if (choice == 3) {
			if (((KlingonFleet) kf).getShieldStrength() == 0) {
				if (((KlingonFleet) kf).getrNum() > 0) {
					((KlingonFleet) kf).defence1(ff, kf);
				} else
					aiChoiceKling(ff, kf);
			} else
				aiChoiceKling(ff, kf);
		} else if (choice == 4) {
			if (((KlingonFleet) kf).getHullStrengthA() < 50) {
				if (((KlingonFleet) kf).gethNum() > 0) {
					((KlingonFleet) kf).defence2(ff, kf);
				} else
					aiChoiceKling(ff, kf);
			} else
				aiChoiceKling(ff, kf);
		}
	}

	public static void aiChoiceFed(Object ff, Object kf) {
		Random x = new Random();
		int choice = 1 + x.nextInt(4);

		if (choice == 1) {
			((FederationFleet) ff).attack1(ff, kf);
		} else if (choice == 2) {
			if (((FederationFleet) ff).gettNum() > 0) {
				((FederationFleet) ff).attack2(ff, kf);
			} else if (((FederationFleet) ff).gettNum() == 0) {
				aiChoiceFed(ff, kf);
			}
		} else if (choice == 3) {
			if (((FederationFleet) ff).getShieldStrength() == 0) {
				if (((FederationFleet) ff).getrNum() > 0) {
					((FederationFleet) ff).defence1(ff, kf);
				} else
					aiChoiceFed(ff, kf);
			} else
				aiChoiceKling(ff, kf);
		} else if (choice == 4) {
			if (((FederationFleet) ff).getHullStrengthA() < 50) {
				if (((FederationFleet) ff).gethNum() > 0) {
					((FederationFleet) ff).defence2(ff, kf);
				} else
					aiChoiceFed(ff, kf);
			} else
				aiChoiceFed(ff, kf);
		}
	}

}
