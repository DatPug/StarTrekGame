
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChooseShips {
	
	static Object x;
	static Object y;
	
	private static String fName;
	private static String kName;
	
	private boolean ai = false;
	static boolean fed = false;
	static boolean kling = false;
	
	private Scanner in = new Scanner(System.in);
	
	public static String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		ChooseShips.fName = fName;
	}

	public static String getkName() {
		return kName;
	}

	public void setkName(String kName) {
		ChooseShips.kName = kName;
	}

	public String enterNameF() {
		// gives Federation ship a name
		System.out.println("Federation Captain, enter a name for your ship: ");
		String name = in.nextLine().trim();
		return fName = name;
	}

	public String enterNameK() {
		// gives Klingon Ship a name
		System.out.println("Klingon Captain, enter a name for your ship: ");
		String name = in.nextLine().trim();
		return kName = name;
	}

	public String aiKName() {
		// use AI Klingon Name
		
		return kName = classAi.kName; // set predetermined name
	}

	public String aiFName() {
		// use AI Federation Name

		return fName = classAi.fName; // set predetermined name
	}
	
	public boolean isAi() {
		return ai;
	}
	
	Ai classAi = new Ai();
	
	public void fedShip() { // Choice Display for Federation
		System.out.println("Federation Captain select a ship type: ");
		System.out.println(" 1. Offensive ");
		System.out.println("	Shields: " + FederationFleet.b.getShieldStrength());
		System.out.println("	Hull: " + FederationFleet.b.gethullStrength());
		System.out.println("	Torpedoes: " + FederationFleet.b.gettNum() + " | Damage: 40 - 50");
		System.out.println("	Shield Repairs: " + FederationFleet.b.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + FederationFleet.b.gethNum() + " | Repairs: 30 - 35");
		System.out.println("	Phaser Damage: 20 - 30");
		System.out.println(" 2. Well-Rounded ");
		System.out.println("	Shields: " + FederationFleet.a.getShieldStrength());
		System.out.println("	Hull: " + FederationFleet.a.gethullStrength());
		System.out.println("	Torpedoes: " + FederationFleet.a.gettNum() + " | Damage: 30 - 40");
		System.out.println("	Shield Repairs: " + FederationFleet.a.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + FederationFleet.a.gethNum() + " | Repairs: 30 - 40");
		System.out.println("	Phaser Damage: 10 - 25");
		System.out.println(" 3. Defensive ");
		System.out.println("	Shields: " + FederationFleet.c.getShieldStrength());
		System.out.println("	Hull: " + FederationFleet.c.gethullStrength());
		System.out.println("	Torpedoes: " + FederationFleet.c.gettNum() + " | Damage: 20 - 40");
		System.out.println("	Shield Repairs: " + FederationFleet.c.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + FederationFleet.c.gethNum() + " | Repairs: 35 - 50");
		System.out.println("	Phaser Damage: 10 - 20");
	}

	public void klingShip() { // Choice Display for Klingons
		System.out.println("Klingon Captain, select a ship type: ");
		System.out.println(" 1. Offensive ");
		System.out.println("	Shields: " + KlingonFleet.b.getShieldStrength());
		System.out.println("	Hull: " + KlingonFleet.b.gethullStrength());
		System.out.println("	Torpedoes: " + KlingonFleet.b.gettNum() + " | Damage: 40 - 50");
		System.out.println("	Shield Repairs: " + KlingonFleet.b.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + KlingonFleet.b.gethNum() + " | Repairs: 30 - 35");
		System.out.println("	Disruptor Damage: 20 - 30");
		System.out.println(" 2. Well-Rounded ");
		System.out.println("	Shields: " + KlingonFleet.a.getShieldStrength());
		System.out.println("	Hull: " + KlingonFleet.a.gethullStrength());
		System.out.println("	Torpedoes: " + KlingonFleet.a.gettNum() + " | Damage: 30 - 40");
		System.out.println("	Shield Repairs: " + KlingonFleet.a.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + KlingonFleet.a.gethNum() + " | Repairs: 30 - 40");
		System.out.println("	Disruptor Damage: 15 - 25");
		System.out.println(" 3. Defensive ");
		System.out.println("	Shields: " + KlingonFleet.c.getShieldStrength());
		System.out.println("	Hull: " + KlingonFleet.c.gethullStrength());
		System.out.println("	Torpedoes: " + KlingonFleet.c.gettNum() + " | Damage: 20 - 40");
		System.out.println("	Shield Repairs: " + KlingonFleet.c.getrNum() + " | Repairs: 20 - 30");
		System.out.println("	Hull Repairs: " + KlingonFleet.c.gethNum() + " | Repairs: 35 - 50");
		System.out.println("	Disruptor Damage: 10 - 20");
	}

	public void players() {
		System.out.println("One Player or Two?");
		System.out.println(" 1. One");
		System.out.println(" 2. Two");
	}

	public void fleets() {
		System.out.println("Federation or Klingon?");
		System.out.println(" 1. Federation");
		System.out.println(" 2. Klingon");
	}

	public void aiChoiceK() throws InterruptedException {
		System.out.println("Computer is choosing a Ship...");
		TimeUnit.SECONDS.sleep(2);
		classAi.aiChooseKling();
		aiKName();
	}

	public void aiChoiceF() throws InterruptedException {
		System.out.println("Computer is choosing a Ship...");
		TimeUnit.SECONDS.sleep(2);
		classAi.aiChooseFed();
		aiFName();
	}

	public void chooseShips() throws IOException, InterruptedException {
		char choice, ignore;

		do {

			players(); //asks how many players there are.

			choice = (char) System.in.read();

			do {
				ignore = (char) System.in.read();
			} while (ignore != '\n');
		} while (choice < '1' | choice > '2');

		switch (choice) { // Player One chooses whether Federation or Klingon
		case '1': // if One player 
			ai = true; 
			do {
				fleets(); //asks which fleet you wish to play as

				choice = (char) System.in.read();

				do {
					ignore = (char) System.in.read();
				} while (ignore != '\n');
			} while (choice < '1' | choice > '2');

			switch (choice) {
			case '1': // federation is chosen
				fed = true;
				if (ai == true) {

					aiChoiceK(); //makes the Ai choose a ship to play as

				}
				do {

					enterNameF(); //input for a name
					fedShip(); // choice of ship

					choice = (char) System.in.read();

					do {
						ignore = (char) System.in.read();
					} while (ignore != '\n');
				} while (choice < '1' | choice > '3');

				switch (choice) {
				case '1': // select Offensive
					x = FederationFleet.b;
					break;
				case '2': // Select Well-Rounded
					x = FederationFleet.a;
					break;
				case '3': // Select Defensive
					x = FederationFleet.c;
					break;
				}

				System.out.println("Player is playing as: The USS " + fName + "\n");
				// stores selection in x

				break;
				

			case '2': // choose klingon
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
					x = KlingonFleet.b;
					break;
				case '2':
					x = KlingonFleet.a;
					break;
				case '3':
					x = KlingonFleet.c;
					break;
				}

				System.out.println("Player is playing as: The KDF " + kName + "\n");
				// stores selection in x

				break;
			}
			
			break;

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