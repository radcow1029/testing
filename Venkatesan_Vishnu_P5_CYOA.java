import java.util.Scanner; // Import Scanner Class

public class Venkatesan_Vishnu_P5_CYOA {
   Scanner myScanner = new Scanner(System.in); // Scanner myScanner
	Scanner enterScanner = new Scanner(System.in); // Scanner enterScaner
	int playerHealth; // Variable for Player's Health
	String playerName; // Variable for Player's Name
	String playerWeapon; // Variable for Player's Weapon
	int choice; // Variable for Choice Number
	int creatureHealth; // Variable for Creature Health
   
   int goldRing; // Can be obtained after successful completion of game
   
   public static void main(String[] args) {
      Venkatesan_Vishnu_P5_CYOA survival;
      survival = new Venkatesan_Vishnu_P5_CYOA(); 
      survival.playerDefault();
      survival.kingdomGate();
	}

	public void playerDefault() { // Player Default Method

		playerHealth = 10; // Setting Player's Health to 10
		creatureHealth = 15; //Setting Creature's Health to 15

		playerWeapon = "Bat"; // Player's Default Weapon is Bat

		System.out.println("Health -- " + playerHealth);
		System.out.println("Weapon -- " + playerWeapon);

		System.out.println("Type Your Name --");

		playerName = myScanner.nextLine();

		System.out.println("Hello " + playerName + ", let the games begin!!");

	}

	public void kingdomGate() { // Kingdom Gate Method

		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at the gate of the Kingdom of Ipratus.");
		System.out.println("A guard is standing right in front of you.");
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.println("");
		System.out.println("1: Talk politely to the guard");
		System.out.println("2: Attack the guard brutally");
		System.out.println("3: Exit the area");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) { // If Statement
			if (goldRing == 1) { // If Statement
				ending();
			} else { // Else Statement
				System.out.println("Guard: O stranger! I see that your name is " + playerName + "? \nSorry, however, as per our King's orders, we are not allowed to let unknown individuals into our Kingdom.");
				enterScanner.nextLine();
				kingdomGate();
			}
 
		} else if (choice == 2) { // Else If Statement
			playerHealth = playerHealth - 1;
			System.out.println("Guard: Hey, don't be an idiot.\n\nThe guard hit you so hard and you gave up, embarrassed to lose to a gentlemen twice your age. He questions your might.\n(You receive 1 damage)\n");
			System.out.println("Health -- " + playerHealth);
			enterScanner.nextLine();
			kingdomGate();
		} else if (choice == 3) { // Else If Statement
			intersection();
		} else { // Else Statement
			kingdomGate();
		}
	}

	public void intersection() { // Intersection Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at an intersection. If you go South, you will go back to the Kingdom.\n\n");
		System.out.println("1: Go towards the North");
		System.out.println("2: Go towards the East");
		System.out.println("3: Go towards the South");
		System.out.println("4: Go towards the West");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) { // If Statement
			north();
		} else if (choice == 2) { // Else If Statement
			east();
		} else if (choice == 3) { // Else If Statement
			kingdomGate();
		} else if (choice == 4) { // Else If Statement
			west();
		} else { // Else Statement
			intersection();
		}
	}

	public void north() { // North Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You see a beautiful river far ahead of you, choose to drink the water, and sleep by the river for a while");
		System.out.println("Health is recovered.");
		playerHealth = playerHealth + 1;
		System.out.println("Health -- " + playerHealth);
		System.out.println("\n\n1: Go back to intersection");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) { // If Statement
			intersection();
		} else { // Else Statement
			north();
		}
	}

	public void east() { // East Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You walk into a mysterious forest and find a Majestic Sword!");
		playerWeapon = "Majestic Sword";
		System.out.println("Weapon -- " + playerWeapon);
		System.out.println("\n\n1: Go back to the intersection");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) { // If Statement
			intersection();
		} else { // Else Statement
			east();
		}
	}

	public void west() { // West Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You cross paths with a frightening Ogre!\n");
		System.out.println("1: Fight with all your Might");
		System.out.println("2: Run as Fast as you Can!!");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) { // If Statement
			fight();
		} else if (choice == 2) { // Else If Statement
			intersection();
		} else { // Else Statement
			west();
		}
	}

	public void fight() { // Fight Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Health -- " + playerHealth);
		System.out.println("Villain Health -- " + creatureHealth);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) { // If Statement
			attack();
		} else if (choice == 2) { // Else If Statement
			intersection();
		} else { // Else Statement
			fight();
		}
	}

	public void attack() { // Attack Method
		int playerDamage = 0; // Setting Player Damage to 0

		if (playerWeapon.equals("Bat")) { // If Statement
			playerDamage = new java.util.Random().nextInt(5);
		} else if (playerWeapon.equals("Majestic Sword")) { // Else If Statement
			playerDamage = new java.util.Random().nextInt(8);
		}

		System.out.println("You attack the creature and give " + playerDamage + " damage!");

		creatureHealth = creatureHealth - playerDamage;

		System.out.println("creatureHealth: " + creatureHealth);

		if (creatureHealth < 1) { // If Statement
			win();
		} else if (creatureHealth > 0) { // Else If Statement
			int creatureDamage = 0; // Setting Creature Damage to 0

			creatureDamage = new java.util.Random().nextInt(4);

			System.out.println("The creature attacks you and gives " + creatureDamage + " damage!");

			playerHealth = playerHealth - creatureDamage;

			System.out.println("Player Health -- " + playerHealth);

			if (playerHealth < 1) { // If Statement
				death();
			} else if (playerHealth > 0) { // Else If Statement
				fight();
			}
		}

	}

	public void death() { // Death Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You have died :'(");
		System.out.println("\n\nThe Game is Over.");
		System.out.println("\n------------------------------------------------------------------\n");

	}

	public void win() { // Win Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You managed to kill the creature!");
		System.out.println("The creature dropped a ring!");
		System.out.println("You got a gold ring!\n\n");
		System.out.println("1: Go East");
		System.out.println("\n------------------------------------------------------------------\n");

		goldRing = 1; // Setting Gold Ring to 1

		choice = myScanner.nextInt();
		if (choice == 1) { // If Statement
			intersection();
		} else { // Else Statement
			win();
		}

	}

	public void ending() { // Ending Method
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Guard: O! Good sir, have thou miraculously killed the great demon Ogre?? Splendid!!");
		System.out.println("Guard: It seems you are a trustworthy lad. Welcome to our Kingdom!!!");
		System.out.println("\n\n           THE END                    ");
		System.out.println("\n------------------------------------------------------------------\n");
	}
}