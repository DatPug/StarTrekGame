package CombatSpace;
import java.util.Random;

public interface Commands {

	int shieldStrength = 100; // Shields
	int hullStrength = 100; // hull

	public void attackMenu(Object ff, Object kf);

	public static void attack1(Object ff, Object kf) {
		Random damage = new Random();
		int energy = 0;

		if (OnePlayerTurn.fed) {
			if (FederationFleet.a == ff) { // Well-Rounded Damage
				energy = 15 + damage.nextInt(10);
			}
			if (FederationFleet.b == ff) { // Offensive Damage
				energy = 20 + damage.nextInt(10);
			}
			if (FederationFleet.c == ff) { // Defensive damage
				energy = 10 + damage.nextInt(10);
			}
			System.out.println("The USS " + ChooseShips.getfName() + " is firing phasers!\n");
			((KlingonFleet) kf).setShieldStrength(((KlingonFleet) kf).getShieldStrength() - energy); // damage
																										// shields
			System.out.println("The USS " + ChooseShips.getfName() + " dealt " + energy + " damage.");
			if (((KlingonFleet) kf).getShieldStrength() <= 0) {
				int x = Math.abs(((KlingonFleet) kf).getShieldStrength());
				((KlingonFleet) kf).sethullStrength(((KlingonFleet) kf).gethullStrength() - x); // remaining
																									// damage
																									// to
																									// hull
				((KlingonFleet) kf).setShieldStrength(0); // set shields to 0
			} else if (((KlingonFleet) kf).getShieldStrength() == 0) {
				((KlingonFleet) kf).sethullStrength(((KlingonFleet) kf).gethullStrength() - energy); // damage
																										// hull
			}
			
		} else  {
			if (KlingonFleet.a == kf) { // Well-Rounded Damage
				energy = 15 + damage.nextInt(10);
			}
			if (KlingonFleet.b == kf) { // Offensive Damage
				energy = 20 + damage.nextInt(10);
			}
			if (KlingonFleet.c == kf) { // Defensive Damage
				energy = 10 + damage.nextInt(10);
			}
			System.out.println("The KDF " + ChooseShips.getkName() + " is firing disruptors!\n");
			((FederationFleet) ff).setShieldStrength(((FederationFleet) ff).getShieldStrength() - energy); // damage
																											// shields
			System.out.println("The KDF " + ChooseShips.getkName() + " dealt " + energy + " damage.");
			if (((FederationFleet) ff).getShieldStrength() <= 0) {
				int x = Math.abs(((FederationFleet) ff).getShieldStrength());
				((FederationFleet) ff).sethullStrength(((FederationFleet) ff).gethullStrength() - x); // remaining
																										// damage
																										// to
																										// hull
				((FederationFleet) ff).setShieldStrength(0); // set shields to 0
			} else if (((FederationFleet) ff).getShieldStrength() == 0) {
				((FederationFleet) ff).sethullStrength(((FederationFleet) ff).gethullStrength() - energy); // damage
																												// hull
			}
		}

	}

	public static void attack2(Object ff, Object kf) {
		Random damage = new Random();
		int torpedo = 0;
		if (OnePlayerTurn.fed) {
			if (FederationFleet.a == ff) { // Well Rounded Damage
				torpedo = 30 + damage.nextInt(10);
			}
			if (FederationFleet.b == ff) { // Offensive damage
				torpedo = 40 + damage.nextInt(10);
			}
			if (FederationFleet.c == ff) { // Defensive Damage
				torpedo = 20 + damage.nextInt(20);
			}
			if (((FederationFleet) ff).gettNum() >= 1) {
				System.out.println("The USS " + ChooseShips.getfName() + " fired a spread of photon torpedos!\n");
				((KlingonFleet) kf).setShieldStrength(((KlingonFleet) kf).getShieldStrength() - torpedo); // damage
																											// shields
				System.out.println("The USS " + ChooseShips.getfName() + " dealt " + torpedo + " damage.");
				if (((KlingonFleet) kf).getShieldStrength() <= 0) {
					int x = Math.abs(((KlingonFleet) kf).getShieldStrength());
					((KlingonFleet) kf).sethullStrength(((KlingonFleet) kf).gethullStrength() - x); // remaining
																										// damage
																										// to
					// hull
					((KlingonFleet) kf).setShieldStrength(0); // set shields to
																// 0
				} else if (((KlingonFleet) kf).getShieldStrength() == 0) {
					((KlingonFleet) kf).sethullStrength(((KlingonFleet) kf).gethullStrength() - torpedo); // damage
																											// hull
				}
				((FederationFleet) ff).settNum(((FederationFleet) ff).gettNum() - 1);
			} else if (((FederationFleet) ff).gettNum() <= 0) {
				((FederationFleet) ff).settNum(0);
			}
			
		} else {
			if (KlingonFleet.a == kf) { // Well-Rounded Damage
				torpedo = 30 + damage.nextInt(10);
			}
			if (KlingonFleet.b == kf) { // Offensive Damage
				torpedo = 40 + damage.nextInt(10);
			}
			if (KlingonFleet.c == kf) { // Defensives Damage
				torpedo = 20 + damage.nextInt(20);
			}
			if (((KlingonFleet) kf).gettNum() >= 1) {
				System.out.println("The KDF " + ChooseShips.getkName() + " fired a spread of photon torpedos!\n");
				((FederationFleet) ff).setShieldStrength(((FederationFleet) ff).getShieldStrength() - torpedo); // damage
																												// shields
				System.out.println("The KDF " + ChooseShips.getkName() + " dealt " + torpedo + " damage.");
				if (((FederationFleet) ff).getShieldStrength() <= 0) {
					int x = Math.abs(((FederationFleet) ff).getShieldStrength());
					((FederationFleet) ff).sethullStrength(((FederationFleet) ff).gethullStrength() - x); // remaining
																											// damage
																											// to
					// hull
					((FederationFleet) ff).setShieldStrength(0); // set shields
																	// to 0
				} else if (((FederationFleet) ff).getShieldStrength() == 0) {
					((FederationFleet) ff).sethullStrength(((FederationFleet) ff).gethullStrength() - torpedo); // damage
																													// hull
				}
				((KlingonFleet) kf).settNum(((KlingonFleet) kf).gettNum() - 1);
			} else if (((KlingonFleet) kf).gettNum() <= 0) {
				((KlingonFleet) kf).settNum(0);
			}

		}
	}

	public static void defence1(Object ff, Object kf) {
		Random repair = new Random();
		int shield = 30 + repair.nextInt(10);

		if (OnePlayerTurn.fed) {
			if (((FederationFleet) ff).getrNum() >= 1) {
				System.out.println("The USS " + ChooseShips.getfName() + " repaired shields by " + shield + "%");
				((FederationFleet) ff).setShieldStrength(((FederationFleet) ff).getShieldStrength() + shield);
				((FederationFleet) ff).setrNum(((FederationFleet) ff).getrNum() - 1);

				if (((FederationFleet) ff).getShieldStrength() > 100) {
					((FederationFleet) ff).setShieldStrength(100);
				}

				System.out.println("Shields are at " + ((FederationFleet) ff).getShieldStrength() + "%");
			} else if (((FederationFleet) ff).getrNum() <= 0) {
				((FederationFleet) ff).setrNum(0);
			}
		} else {
			if (((KlingonFleet) kf).getrNum() >= 1) {
				System.out.println("The KDF " + ChooseShips.getkName() + " repaired shields by " + shield + "%");
				((KlingonFleet) kf).setShieldStrength(((KlingonFleet) kf).getShieldStrength() + shield);
				((KlingonFleet) kf).setrNum(((KlingonFleet) kf).getrNum() - 1);

				if (((KlingonFleet) kf).getShieldStrength() > 100) {
					((KlingonFleet) kf).setShieldStrength(100);
				}
				System.out.println("Shields are at " + ((KlingonFleet) kf).getShieldStrength() + "%");
			} else if (((KlingonFleet) kf).gethNum() <= 0) {
				((KlingonFleet) kf).setrNum(0);
			}
		}

	}

	public static void defence2(Object ff, Object kf) {
		Random repair = new Random();
		int hull = 0;
		int y;
		int x;

		if (OnePlayerTurn.fed) {

			int h = ((FederationFleet) ff).gethullStrength();
			if (FederationFleet.a == ff) { // Well-Rounded repair
				hull = 30 + repair.nextInt(10);
			}
			if (FederationFleet.b == ff) { // Offensive Repair
				hull = 30 + repair.nextInt(5);
			}
			if (FederationFleet.c == ff) { // Defensive Repair
				hull = 35 + repair.nextInt(15);
			}
			if (((FederationFleet) ff).gethNum() >= 1) {
				if (((FederationFleet) ff).gethullStrength() < 100) {
					System.out.println("The USS " + ChooseShips.getfName() + " repaired hull by " + hull + "%");

					((FederationFleet) ff).sethullStrength(((FederationFleet) ff).gethullStrength() + hull);
					((FederationFleet) ff).sethNum(((FederationFleet) ff).gethNum() - 1);

					if (((FederationFleet) ff).gethullStrength() >= 100) {
						((FederationFleet) ff).sethullStrength(100);

					}

					System.out.println("Hull is at " + ((FederationFleet) ff).gethullStrength() + "%\n");

					if ((h + hull) >= 100) {
						y = (h + hull) - ((FederationFleet) ff).gethullStrength();
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

		} else {

			int h = ((KlingonFleet) kf).gethullStrength();

			if (KlingonFleet.a == kf) { // Well-Rounded Repair
				hull = 30 + repair.nextInt(10);
			}
			if (KlingonFleet.b == kf) { // Offensive Repair
				hull = 30 + repair.nextInt(5);
			}
			if (KlingonFleet.c == kf) { // Defensive Repair
				hull = 35 + repair.nextInt(15);
			}
			if (((KlingonFleet) kf).gethNum() >= 1) {
				if (((KlingonFleet) kf).gethullStrength() < 100) {
					System.out.println("The KDF " + ChooseShips.getkName() + " repaired hull by " + hull + "%");

					((KlingonFleet) kf).sethullStrength(((KlingonFleet) kf).gethullStrength() + hull);
					((KlingonFleet) kf).sethNum(((KlingonFleet) kf).gethNum() - 1);

					if (((KlingonFleet) kf).gethullStrength() >= 100) {
						((KlingonFleet) kf).sethullStrength(100);

					}
					System.out.println("Hull is at " + ((KlingonFleet) kf).gethullStrength() + "%\n");

					if ((h + hull) >= 100) {
						y = (h + hull) - ((KlingonFleet) kf).gethullStrength();
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

	}
}