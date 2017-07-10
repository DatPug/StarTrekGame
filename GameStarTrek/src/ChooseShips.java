
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChooseShips {
	public static Object x;
	public static Object y;
	static Scanner in = new Scanner(System.in);
	static String fName;
	static String kName;
	static boolean ai = false;
	static boolean fed = false;
	static boolean kling = false;

	public static String enterNameF() {

		System.out.println("Federation Captain, enter a name for your ship: ");
		String name = in.nextLine();
		return ChooseShips.fName = name;
	}

	public static String enterNameK() {

		System.out.println("Klingon Captain, enter a name for your ship: ");
		String name = in.nextLine();
		return ChooseShips.kName = name;
	}

	public static String aiKName() {
		return ChooseShips.kName = Ai.kName;
	}

	public static String aiFName() {
		return ChooseShips.fName = Ai.fName;
	}

	public static void fedShip() {
		System.out.println("Federation Captain select a ship type: ");
		System.out.println(" 1. Offensive ");
		System.out.println("	Shields: " + FederationFleet.b.getShieldStrength());
		System.out.println("	Hull: " + FederationFleet.b.getHullStrengthA());
		System.out.println("	Torpedoes: " + FederationFleet.b.gettNum() + " | Damage: 40 - 50");
		System.out.println("	Shield Repairs: " + FederationFleet.b.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + FederationFleet.b.gethNum() + " | Repairs: 30 - 35");
		System.out.println("	Phaser Damage: 20 - 30");
		System.out.println(" 2. Well-Rounded ");
		System.out.println("	Shields: " + FederationFleet.a.getShieldStrength());
		System.out.println("	Hull: " + FederationFleet.a.getHullStrengthA());
		System.out.println("	Torpedoes: " + FederationFleet.a.gettNum() + " | Damage: 30 - 40");
		System.out.println("	Shield Repairs: " + FederationFleet.a.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + FederationFleet.a.gethNum() + " | Repairs: 30 - 40");
		System.out.println("	Phaser Damage: 10 - 25");
		System.out.println(" 3. Defensive ");
		System.out.println("	Shields: " + FederationFleet.c.getShieldStrength());
		System.out.println("	Hull: " + FederationFleet.c.getHullStrengthA());
		System.out.println("	Torpedoes: " + FederationFleet.c.gettNum() + " | Damage: 20 - 40");
		System.out.println("	Shield Repairs: " + FederationFleet.c.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + FederationFleet.c.gethNum() + " | Repairs: 35 - 50");
		System.out.println("	Phaser Damage: 10 - 20");
	}

	public static void klingShip() {
		System.out.println("Klingon Captain, select a ship type: ");
		System.out.println(" 1. Offensive ");
		System.out.println("	Shields: " + KlingonFleet.b.getShieldStrength());
		System.out.println("	Hull: " + KlingonFleet.b.getHullStrengthA());
		System.out.println("	Torpedoes: " + KlingonFleet.b.gettNum() + " | Damage: 40 - 50");
		System.out.println("	Shield Repairs: " + KlingonFleet.b.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + KlingonFleet.b.gethNum() + " | Repairs: 30 - 35");
		System.out.println("	Disruptor Damage: 20 - 30");
		System.out.println(" 2. Well-Rounded ");
		System.out.println("	Shields: " + KlingonFleet.a.getShieldStrength());
		System.out.println("	Hull: " + KlingonFleet.a.getHullStrengthA());
		System.out.println("	Torpedoes: " + KlingonFleet.a.gettNum() + " | Damage: 30 - 40");
		System.out.println("	Shield Repairs: " + KlingonFleet.a.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + KlingonFleet.a.gethNum() + " | Repairs: 30 - 40");
		System.out.println("	Disruptor Damage: 15 - 25");
		System.out.println(" 3. Defensive ");
		System.out.println("	Shields: " + KlingonFleet.c.getShieldStrength());
		System.out.println("	Hull: " + KlingonFleet.c.getHullStrengthA());
		System.out.println("	Torpedoes: " + KlingonFleet.c.gettNum() + " | Damage: 20 - 40");
		System.out.println("	Shield Repairs: " + KlingonFleet.c.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + KlingonFleet.c.gethNum() + " | Repairs: 35 - 50");
		System.out.println("	Disruptor Damage: 10 - 20");
	}

	public static void players() {
		System.out.println("One Player or Two?");
		System.out.println(" 1. One");
		System.out.println(" 2. Two");
	}

	public static void fleets() {
		System.out.println("Federation or Klingon?");
		System.out.println(" 1. Federation");
		System.out.println(" 2. Klingon");
	}

	public static void aiChoiceK() throws InterruptedException {
		System.out.println("Computer is choosing a Ship...");
		TimeUnit.SECONDS.sleep(2);
		Ai.aiChooseKling();
		aiKName();
	}

	public static void aiChoiceF() throws InterruptedException {
		System.out.println("Computer is choosing a Ship...");
		TimeUnit.SECONDS.sleep(2);
		Ai.aiChooseFed();
		aiFName();
	}

	public static void chooseShips() throws IOException, InterruptedException {
		char choice, ignore;

		do {

			players();

			choice = (char) System.in.read();

			do {
				ignore = (char) System.in.read();
			} while (ignore != '\n');
		} while (choice < '1' | choice > '2');

		switch (choice) { // Player One chooses whether Federation or Klingon
		case '1':
			ai = true;
			do {
				fleets();

				choice = (char) System.in.read();

				do {
					ignore = (char) System.in.read();
				} while (ignore != '\n');
			} while (choice < '1' | choice > '2');

			switch (choice) {
			case '1':
				fed = true;
				if (ai == true) {

					aiChoiceK();

				}
				do {

					enterNameF();
					fedShip();

					choice = (char) System.in.read();

					do {
						ignore = (char) System.in.read();
					} while (ignore != '\n');
				} while (choice < '1' | choice > '3');

				switch (choice) {
				case '1':
					x = FederationFleet.b;
					break;
				case '2':
					x = FederationFleet.a;
					break;
				case '3':
					x = FederationFleet.c;
					break;
				}

				System.out.println("Player is playing as: The USS " + fName + "\n");
				// stores selection in x

				break;

			case '2':
				kling = true;
				if (ai == true) {

					aiChoiceF();

				}
				do {

					enterNameK();
					klingShip();

					choice = (char) System.in.read();

					do {
						ignore = (char) System.in.read();
					} while (ignore != '\n');
				} while (choice < '1' | choice > '3');

				switch (choice) {
				case '1':
					y = KlingonFleet.b;
					break;
				case '2':
					y = KlingonFleet.a;
					break;
				case '3':
					y = KlingonFleet.c;
					break;
				}

				System.out.println("Player is playing as: The KDF " + kName + "\n");
				// stores selection in x

				break;
			}

		case '2':

			do {

				enterNameF();
				fedShip();

				choice = (char) System.in.read();

				do {
					ignore = (char) System.in.read();
				} while (ignore != '\n');
			} while (choice < '1' | choice > '3');

			switch (choice) {
			case '1':
				x = FederationFleet.b;
				break;
			case '2':
				x = FederationFleet.a;
				break;
			case '3':
				x = FederationFleet.c;
				break;
			}

			System.out.println("Player 1 is playing as: The USS " + fName + "\n");
			// stores selection in x

			do {

				enterNameK();
				klingShip();

				choice = (char) System.in.read();

				do {
					ignore = (char) System.in.read();
				} while (ignore != '\n');
			} while (choice < '1' | choice > '3');

			switch (choice) { 
			case '1':
				y = KlingonFleet.b;
				break;
			case '2':
				y = KlingonFleet.a;
				break;
			case '3':
				y = KlingonFleet.c;
				break;
			}
			System.out.println("Player 2 is playing as: The KDF " + kName);

		}
		// stores selection in y

	}
}