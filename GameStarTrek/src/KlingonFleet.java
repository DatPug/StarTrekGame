
import java.io.IOException;
import java.util.Random;

public enum KlingonFleet {

	a("The KDF " + ChooseShips.kName, 100, 100, 2, 2, 2), b("The KDF " + ChooseShips.kName, 50, 100, 3, 1,
			1), c("The KDF " + ChooseShips.kName, 150, 100, 3, 2, 2);

	private int shieldStrength; // Shields
	private int hullStrengthA; // hull
	private int tNum; // torpedo ammo
	private int rNum; // repair shields amount
	private int hNum; // hull repair amount

	KlingonFleet(String name, int shieldStrength, int hullStrengthA, int tNum, int rNum, int hNum) {

		this.setShieldStrength(shieldStrength);
		this.setHullStrengthA(hullStrengthA);
		this.settNum(tNum);
		this.setrNum(rNum);
		this.sethNum(hNum);
	}

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
			System.out.println("Player 2's Turn:");
		} else {
			System.out.println("Computer's Turn:");
		}
		System.out.println("The KDF " + ChooseShips.kName + ": \n");
		System.out.println("Shields are at: " + ((KlingonFleet) kf).getShieldStrength() + "%");
		System.out.println("Hull is at: " + ((KlingonFleet) kf).getHullStrengthA() + "%\n");
		System.out.println("Captain, give an order: ");
		System.out.println("  1. Disrupter");
		System.out.println("  2. Torpedo | " + "you have " + ((KlingonFleet) kf).gettNum() + " left");
		if (a == kf) {
			if (((KlingonFleet) kf).getShieldStrength() < 100) {
				System.out.println("  3. Repair Shields | " + "you have " + ((KlingonFleet) kf).getrNum() + " left");
			}
		}
		if (b == kf) {
			if (((KlingonFleet) kf).getShieldStrength() < 50) {
				System.out.println("  3. Repair Shields | " + "you have " + ((KlingonFleet) kf).getrNum() + " left");
			}
		}
		if (c == kf) {
			if (((KlingonFleet) kf).getShieldStrength() < 150) {
				System.out.println("  3. Repair Shields | " + "you have " + ((KlingonFleet) kf).getrNum() + " left");
			}
		}
		if (((KlingonFleet) kf).getHullStrengthA() < 100) {
			System.out.println("  4. Hull Repair | " + "you have " + ((KlingonFleet) kf).gethNum() + " left");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++");
	}

	public void attack1(Object ff, Object kf) {
		// Disruptor Method
		Random damage = new Random();
		int disruptor = 0;
		if (a == kf) {
			disruptor = 15 + damage.nextInt(10);
		}
		if (b == kf) {
			disruptor = 20 + damage.nextInt(10);
		}
		if (c == kf) {
			disruptor = 10 + damage.nextInt(10);
		}
		System.out.println("The KDF " + ChooseShips.kName + " is firing disruptors!\n");
		((FederationFleet) ff).setShieldStrength(((FederationFleet) ff).getShieldStrength() - disruptor); // damage
																											// shields
		System.out.println("The KDF " + ChooseShips.kName + " dealt " + disruptor + " damage.");
		if (((FederationFleet) ff).getShieldStrength() <= 0) {
			int x = Math.abs(((FederationFleet) ff).getShieldStrength());
			((FederationFleet) ff).setHullStrengthA(((FederationFleet) ff).getHullStrengthA() - x); // remaining
																									// damage
																									// to
																									// hull
			((FederationFleet) ff).setShieldStrength(0); // set shields to 0
		} else if (((FederationFleet) ff).getShieldStrength() == 0) {
			((FederationFleet) ff).setHullStrengthA(((FederationFleet) ff).getHullStrengthA() - disruptor); // damage
																											// hull
		}
	}

	public void attack2(Object ff, Object kf) {
		// Torpedo Method
		Random damage = new Random();
		int torpedo = 0;
		if (a == kf) {
			torpedo = 30 + damage.nextInt(10);
		}
		if (b == kf) {
			torpedo = 40 + damage.nextInt(10);
		}
		if (c == kf) {
			torpedo = 20 + damage.nextInt(20);
		}
		if (gettNum() >= 1) {
			System.out.println("The KDF " + ChooseShips.kName + " fired a spread of photon torpedos!\n");
			((FederationFleet) ff).setShieldStrength(((FederationFleet) ff).getShieldStrength() - torpedo); // damage
																											// shields
			System.out.println("The KDF " + ChooseShips.kName + " dealt " + torpedo + " damage.");
			if (((FederationFleet) ff).getShieldStrength() <= 0) {
				int x = Math.abs(((FederationFleet) ff).getShieldStrength());
				((FederationFleet) ff).setHullStrengthA(((FederationFleet) ff).getHullStrengthA() - x); // remaining
																										// damage
																										// to
				// hull
				((FederationFleet) ff).setShieldStrength(0); // set shields to 0
			} else if (((FederationFleet) ff).getShieldStrength() == 0) {
				((FederationFleet) ff).setHullStrengthA(((FederationFleet) ff).getHullStrengthA() - torpedo); // damage
																												// hull
			}
			settNum(gettNum() - 1);
		} else if (gettNum() <= 0) {
			settNum(0);
		}
	}

	public void defence1(Object ff, Object kf) {
		// Shield Repair
		Random repair = new Random();
		int shield = 30 + repair.nextInt(10);
		if (getrNum() >= 1) {
			System.out.println("The KDF " + ChooseShips.kName + " repaired shields by " + shield + "%");
			((KlingonFleet) kf).setShieldStrength(((KlingonFleet) kf).getShieldStrength() + shield);
			((KlingonFleet) kf).setrNum(((KlingonFleet) kf).getrNum() - 1);
			if (a == kf) {
				if (((KlingonFleet) kf).getShieldStrength() > 100) {
					((KlingonFleet) kf).setShieldStrength(100);
				}
			}
			if (b == kf) {
				if (((KlingonFleet) kf).getShieldStrength() > 50) {
					((KlingonFleet) kf).setShieldStrength(50);
				}
			}
			if (c == kf) {
				if (((KlingonFleet) kf).getShieldStrength() > 150) {
					((KlingonFleet) kf).setShieldStrength(150);
				}
			}
			System.out.println("Shields are at " + ((KlingonFleet) kf).getShieldStrength() + "%");
		} else if (((KlingonFleet) kf).gethNum() <= 0) {
			((KlingonFleet) kf).setrNum(0);
		}

	}

	public void defence2(Object ff, Object kf) {
		// Hull Repair Method
		Random repair = new Random();
		int hull = 0;
		int h = ((KlingonFleet) kf).getHullStrengthA();
		int y;
		int x;

		if (a == kf) {
			hull = 30 + repair.nextInt(10);
		}
		if (b == kf) {
			hull = 30 + repair.nextInt(5);
		}
		if (c == kf) {
			hull = 35 + repair.nextInt(15);
		}
		if (((KlingonFleet) kf).gethNum() >= 1) {
			if (((KlingonFleet) kf).getHullStrengthA() < 100) {
				System.out.println("The KDF " + ChooseShips.kName + " repaired hull by " + hull + "%");

				((KlingonFleet) kf).setHullStrengthA(((KlingonFleet) kf).getHullStrengthA() + hull);
				((KlingonFleet) kf).sethNum(((KlingonFleet) kf).gethNum() - 1);

				if (a == kf) {

					if (((KlingonFleet) kf).getHullStrengthA() >= 100) {
						((KlingonFleet) kf).setHullStrengthA(100);

					}
				}
				if (b == kf) {

					if (((KlingonFleet) kf).getHullStrengthA() >= 100) {
						((KlingonFleet) kf).setHullStrengthA(100);

					}
				}
				if (c == kf) {
					if (((KlingonFleet) kf).getHullStrengthA() >= 100) {
						((KlingonFleet) kf).setHullStrengthA(100);

					}
				}
				System.out.println("Hull is at " + ((KlingonFleet) kf).getHullStrengthA() + "%\n");

				if ((h + hull) >= 100) {
					y = (h + hull) - ((KlingonFleet) kf).getHullStrengthA();
					x = y / 2;
					((KlingonFleet) kf).setShieldStrength(((KlingonFleet) kf).getShieldStrength() + x);
					System.out.println("Excess repairs went to Shields");
					System.out.println("Shields repaired by: " + x + "%\n");
					// dissipate leftover to shields
				}
			}
		} else if (((KlingonFleet) kf).gethNum() <= 0) {
			((KlingonFleet) kf).sethNum(0);
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
