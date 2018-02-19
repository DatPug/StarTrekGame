package CombatSpace;
import java.io.IOException;

public enum RomulanFleet implements Commands {

	a("The KDF " + ChooseShips.getkName(), 100, 100, 2, 3, 2), b("The KDF " + ChooseShips.getkName(), 100, 100, 3, 2,
			1), c("The KDF " + ChooseShips.getkName(), 100, 100, 2, 4, 3);

	private int shieldStrength; // Shields
	private int hullStrength; // hull
	private int tNum; // torpedo ammo
	private int rNum; // repair shields amount
	private int hNum; // hull repair amount

	RomulanFleet(String name, int shieldStrength, int hullStrength, int tNum, int rNum, int hNum) {

		this.setShieldStrength(Commands.shieldStrength);
		this.sethullStrength(Commands.hullStrength);
		this.settNum(tNum);
		this.setrNum(rNum);
		this.sethNum(hNum);
	}

	// lines 23 - 60 getters and setters for variables
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

	@Override
	public void attackMenu(Object ff, Object kf) {
		// TODO Auto-generated method stub

	}

	public void choose(Object ff, Object kf, Object rf) throws IOException {
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
