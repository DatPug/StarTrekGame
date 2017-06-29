

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ai {

	public static Object y;
	public static String kName;

	public static void aiChoose() {

		Random x = new Random();
		int choice = 1 + x.nextInt(3);
		

		if (choice == 1) {
			y = KlingonFleet.b;
			kName = "Ke'noq";
			System.out.println();
			System.out.println("Computer chose: The KDF " + Ai.kName);
			System.out.println("Ship type: Offensive \n");
			// stores selection in y
		}

		if (choice == 2) {
			y = KlingonFleet.a;
			kName = "Ye'nak";
			System.out.println();
			System.out.println("Computer chose: The KDF " + Ai.kName);
			System.out.println("Ship type: Well-Rounded \n");
			// stores selection in y
		}

		if (choice == 3) {
			y = KlingonFleet.c;
			kName = "Qolen";
			System.out.println();
			System.out.println("Computer chose: The KDF " + Ai.kName);
			System.out.println("Ship type: Defensive \n");
			// stores selection in y
		}
	}

	public static void aiChoose(Object ff, Object kf) throws InterruptedException {
		Random x = new Random();
		int choice = 1 + x.nextInt(4);

		System.out.println("Computer is making a choice . . . ");
		TimeUnit.SECONDS.sleep(2);
		
		if (choice == 1) {
			((KlingonFleet) kf).attack1(ff, kf);
		} else if (choice == 2) {
			if (((KlingonFleet) kf).gettNum() > 0) {
				((KlingonFleet) kf).attack2(ff, kf);
			} else if (((KlingonFleet) kf).gettNum() == 0) {
				aiChoose(ff, kf);
			}
		} else if (choice == 3) {
			if (((KlingonFleet) kf).getShieldStrength() == 0) {
				if (((KlingonFleet) kf).getrNum() > 0) {
					((KlingonFleet) kf).defence1(ff, kf);
				} else
					aiChoose(ff, kf);
			} else
				aiChoose(ff, kf);
		} else if (choice == 4) {
			if (((KlingonFleet) kf).getHullStrengthA() < 50) {
				if (((KlingonFleet) kf).gethNum() > 0) {
					((KlingonFleet) kf).defence2(ff, kf);
				} else
					aiChoose(ff, kf);
			} else
				aiChoose(ff, kf);
		}
	}
}
