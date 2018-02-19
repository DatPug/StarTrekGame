package CombatSpace;
import java.io.IOException;

public enum KlingonFleet implements Commands {

	a("The KDF " + ChooseShips.getkName(), 100, 100, 2, 3, 2), b("The KDF " + ChooseShips.getkName(), 100, 100, 3, 2,
			1), c("The KDF " + ChooseShips.getkName(), 100, 100, 2, 4, 3);

	private int shieldStrength; // Shields
	private int hullStrength; // hull
	private int tNum; // torpedo ammo
	private int rNum; // repair shields amount
	private int hNum; // hull repair amount

	KlingonFleet(String name, int shieldStrength, int hullStrength, int tNum, int rNum, int hNum) {

		this.setShieldStrength(Commands.shieldStrength);
		this.sethullStrength(Commands.hullStrength);
		this.settNum(tNum);
		this.setrNum(rNum);
		this.sethNum(hNum);
	}

	// lines 26 - 64 getters and setters for variables
	public int getShieldStrength() {
		return shieldStrength;
	}

	public void setShieldStrength(int shieldStrength) {
		this.shieldStrength = shieldStrength;
	}

	public int gethullStrength() {
		return hullStrength;
	}

	public void sethullStrength(int hullStrength) {
		this.hullStrength = hullStrength;
	}

	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int gethNum() {
		return hNum;
	}

	public void sethNum(int hNum) {
		this.hNum = hNum;
	}

	public void attackMenu(Object ff, Object kf) {

		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("Klingon Captain's Turn\n");
		System.out.println("The KDF " + ChooseShips.getkName() + ":");
		System.out.println("Shields are at: " + ((KlingonFleet) kf).getShieldStrength() + "%");
		System.out.println("Hull is at: " + ((KlingonFleet) kf).gethullStrength() + "%\n");
		System.out.println("Captain, give an order: ");
		System.out.println("  1. Disrupter");
		System.out.println("  2. Torpedo | " + "you have " + ((KlingonFleet) kf).gettNum() + " left");
		if (((KlingonFleet) kf).getShieldStrength() < 100) {
			System.out.println("  3. Repair Shields | " + "you have " + ((KlingonFleet) kf).getrNum() + " left");
		}
		if (((KlingonFleet) kf).gethullStrength() < 100) {
			System.out.println("  4. Hull Repair | " + "you have " + ((KlingonFleet) kf).gethNum() + " left");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++");
	}

	public void choose(Object ff, Object kf) throws IOException {
		// Menu and turn choices
		char choice, ignore;
		boolean proceed = false;

		do {
			proceed = false;

			attackMenu(ff, kf);
			choice = (char) System.in.read();

			if ((choice == '2' && gettNum() == 0) | (choice == '3' && getrNum() == 0)
					| (choice == '4' && gethNum() == 0))
				System.out.println("choose again");
			else
				proceed = true;

			do {
				ignore = (char) System.in.read();
			} while (ignore != '\n');
		} while ((choice < '1' | choice > '4') || (proceed == false));

		switch (choice) {
		case '1':
			Commands.attack1(ff, kf);
			break;
		case '2':
			Commands.attack2(ff, kf);
			break;
		case '3':
			Commands.defence1(ff, kf);
			break;
		case '4':
			Commands.defence2(ff, kf);
			break;
		}
	}
}
