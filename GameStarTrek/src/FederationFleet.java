import java.io.IOException;
import java.util.Random;


public enum FederationFleet {

	a("The USS " + ChooseShips.fName, 100, 100, 2, 3, 2), b("The USS " + ChooseShips.fName, 100, 100, 3, 2,
			1), c("The USS " + ChooseShips.fName, 100, 100, 2, 4, 3);

	private int shieldStrength; // Shields
	private int hullStrengthA; // hull
	private int tNum; // torpedo ammo
	private int rNum; // repair shields amount
	private int hNum; // hull repair amount

	FederationFleet(String name, int shieldStrength, int hullStrengthA, int tNum, int rNum, int hNum) {

		this.setShieldStrength(shieldStrength);
		this.setHullStrengthA(hullStrengthA);
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

	public int getHullStrengthA() {
		return hullStrengthA;
	}

	public void setHullStrengthA(int hullStrengthA) {
		this.hullStrengthA = hullStrengthA;
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
		if (ChooseShips.ai == false) {
			System.out.println("Player 1's Turn:\n");
		}
		if(ChooseShips.ai == true && ChooseShips.fed == true) {
			System.out.println("Player's Turn:\n");
		} else if (ChooseShips.ai == true && ChooseShips.kling== true ){
			System.out.println("Computer's Turn:\n");
		}
		System.out.println("The USS " + ChooseShips.fName + ": \n");
		System.out.println("Sheilds are at: " + ((FederationFleet) ff).getShieldStrength() + "%");
		System.out.println("Hull is at: " + ((FederationFleet) ff).getHullStrengthA() + "%\n");
		System.out.println("Captain, give an order: ");
		System.out.println("  1. Phasers");
		System.out.println("  2. Torpedo | " + "you have " + ((FederationFleet) ff).gettNum() + " left");
		if (getShieldStrength() < 100) {
			System.out.println("  3. Repair Shields | " + "you have " + ((FederationFleet) ff).getrNum() + " left");
		}
		if (getHullStrengthA() < 100) {
			System.out.println("  4. Hull Repair | " + "you have " + ((FederationFleet) ff).gethNum() + " left");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++");
	}

	public void attack1(Object ff, Object kf) {
		// Phaser method
		Random damage = new Random();
		int phaser = 0;
		if (a == ff) {
			phaser = 15 + damage.nextInt(10);
		}
		if (b == ff) {
			phaser = 20 + damage.nextInt(10);
		}
		if (c == ff) {
			phaser = 10 + damage.nextInt(10);
		}
		System.out.println("The USS " + ChooseShips.fName + " is firing phasers!\n");
		((KlingonFleet) kf).setShieldStrength(((KlingonFleet) kf).getShieldStrength() - phaser); // damage
																									// shields
		System.out.println("The USS " + ChooseShips.fName + " dealt " + phaser + " damage.");
		if (((KlingonFleet) kf).getShieldStrength() <= 0) {
			int x = Math.abs(((KlingonFleet) kf).getShieldStrength());
			((KlingonFleet) kf).setHullStrengthA(((KlingonFleet) kf).getHullStrengthA() - x); // remaining
																								// damage
																								// to
																								// hull
			((KlingonFleet) kf).setShieldStrength(0); // set shields to 0
		} else if (((KlingonFleet) kf).getShieldStrength() == 0) {
			((KlingonFleet) kf).setHullStrengthA(((KlingonFleet) kf).getHullStrengthA() - phaser); // damage
																									// hull
		}

	}

	public void attack2(Object ff, Object kf) {
		// Torpedo method
		Random damage = new Random();
		int torpedo = 0;
		if (a == ff) {
			torpedo = 30 + damage.nextInt(10);
		}
		if (b == ff) {
			torpedo = 40 + damage.nextInt(10);
		}
		if (c == ff) {
			torpedo = 20 + damage.nextInt(20);
		}
		if (gettNum() >= 1) {
			System.out.println("The USS " + ChooseShips.fName + " fired a spread of photon torpedos!\n");
			((KlingonFleet) kf).setShieldStrength(((KlingonFleet) kf).getShieldStrength() - torpedo); // damage
																										// shields
			System.out.println("The USS " + ChooseShips.fName + " dealt " + torpedo + " damage.");
			if (((KlingonFleet) kf).getShieldStrength() <= 0) {
				int x = Math.abs(((KlingonFleet) kf).getShieldStrength());
				((KlingonFleet) kf).setHullStrengthA(((KlingonFleet) kf).getHullStrengthA() - x); // remaining
																									// damage
																									// to
				// hull
				((KlingonFleet) kf).setShieldStrength(0); // set shields to 0
			} else if (((KlingonFleet) kf).getShieldStrength() == 0) {
				((KlingonFleet) kf).setHullStrengthA(((KlingonFleet) kf).getHullStrengthA() - torpedo); // damage
																										// hull
			}
			((FederationFleet) ff).settNum(((FederationFleet) ff).gettNum() - 1);
		} else if (((FederationFleet) ff).gettNum() <= 0) {
			((FederationFleet) ff).settNum(0);
		}
	}

	public void defence1(Object ff, Object kf) {
		// Shield Repair Method
		Random repair = new Random();
		int shield = 30 + repair.nextInt(10);
		if (((FederationFleet) ff).getrNum() >= 1) {
			System.out.println("The USS " + ChooseShips.fName + " repaired shields by " + shield + "%");
			((FederationFleet) ff).setShieldStrength(((FederationFleet) ff).getShieldStrength() + shield);
			((FederationFleet) ff).setrNum(((FederationFleet) ff).getrNum() - 1);

			if (((FederationFleet) ff).getShieldStrength() > 100) {
				((FederationFleet) ff).setShieldStrength(100);
			}

			System.out.println("Shields are at " + ((FederationFleet) ff).getShieldStrength() + "%");
		} else if (((FederationFleet) ff).getrNum() <= 0) {
			((FederationFleet) ff).setrNum(0);
		}
	}

	public void defence2(Object ff, Object kf) {
		// Hull Repair Method
		Random repair = new Random();
		int hull = 0;
		int h = ((FederationFleet) ff).getHullStrengthA();
		int y;
		int x;

		if (a == ff) {
			hull = 30 + repair.nextInt(10);
		}
		if (b == ff) {
			hull = 30 + repair.nextInt(5);
		}
		if (c == ff) {
			hull = 35 + repair.nextInt(15);
		}
		if (gethNum() >= 1) {
			if (((FederationFleet) ff).getHullStrengthA() < 100) {
				System.out.println("The USS " + ChooseShips.fName + " repaired hull by " + hull + "%");

				((FederationFleet) ff).setHullStrengthA(((FederationFleet) ff).getHullStrengthA() + hull);
				((FederationFleet) ff).sethNum(((FederationFleet) ff).gethNum() - 1);
				
				if (((FederationFleet) ff).getHullStrengthA() >= 100) {
					((FederationFleet) ff).setHullStrengthA(100);

				}

				System.out.println("Hull is at " + ((FederationFleet) ff).getHullStrengthA() + "%\n");

				if ((h + hull) >= 100) {
					y = (h + hull) - ((FederationFleet) ff).getHullStrengthA();
					x = y / 2;
					((FederationFleet) ff).setShieldStrength(((FederationFleet) ff).getShieldStrength() + x);
					System.out.println("Excess repairs went to Shields");
					System.out.println("Shields repaired by: " + x + "%\n");
					// dissipate leftover to shields
				}
			}
		} else if (((FederationFleet) ff).gethNum() <= 0) {
			((FederationFleet) ff).sethNum(0);
		}
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
			attack1(ff, kf);
			break;
		case '2':
			attack2(ff, kf);
			break;
		case '3':
			defence1(ff, kf);
			break;
		case '4':
			defence2(ff, kf);
			break;
		}

	}
}
