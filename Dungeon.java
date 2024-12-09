import java.util.Random; 
import java.util.Scanner;
public class Dungeon{
	private Roster<Enemy> enemyRoster; 

	public Dungeon () {
		enemyRoster = populate();
	}

	public Roster<Enemy> populate() {
		Random r = new Random();
		 enemyRoster = new Roster<Enemy>(30);
		int random; 
		for (int i = 0; i < 30; ++i) {
			//random = r.nextInt(3)+1;
			random = r.nextInt(5);
			Enemy e = new Enemy();
			if(random == 0) {
			e = new Orc();
			}
			if(random == 1) {
			e = new GiantSpider();
			}
			if(random == 2) {
			e = new Slime();
			}
			if(random == 3) {
			e = new Demon();
			}
			if(random == 4) {
			e = new Wraith();
			}
			enemyRoster.addItem(e);
		}
		return enemyRoster;
	}
	
	public void entranceDialogue (Hero adventurer) {
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("Deep in the dungeon, "+adventurer.getName()+" scans the maze-like halls of the dungeon for threats..nothing has shown itself..yet");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("SCReEEeEEeE!!");
		System.out.println("An onslought of foul enemies pour from the depths of the dungeon into the hall!");
		
	}
	
	public void dungeonSimulation (Hero adventurer, Dungeon d, Scanner scnr){
		int i = 0;
		adventurer.fillHolder();
		while (i < 30 && adventurer.getHealth() > 0) {
			System.out.println(enemyRoster.getItem(i).announce);
			while(enemyRoster.getItem(i).getDead()!=true && adventurer.getHealth() > 0) {
				int inp; 
				System.out.println("What will "+adventurer.getName()+" do?");
				System.out.println("0 - Attack");
				System.out.println("1 - Attempt parry");
				System.out.println("2 - Use a potion of healing");
				
				inp = scnr.nextInt();
				if (inp == 0) {
					adventurer.attack(enemyRoster.getItem(i));
					if (enemyRoster.getItem(i).getHealth()>0) {
						enemyRoster.getItem(i).attack(adventurer);
					}	
					else {
						if (i != 29) {
							System.out.println(adventurer.getName()+" continues fighting on into the onslought of attackers");
						}
						else {
							System.out.println("After slaying the very last of the misbegotten horde, "+adventurer.getName()+" finds a treasure trove at the very end of the dungeon hall. They claim their rightful treasure, and leave");
						}
					}
				}
				if (inp == 1) {
					Random r = new Random();
					int coinFlip = r.nextInt(2);
					if (coinFlip == 0) {
						System.out.println(adventurer.getName()+" manages to evade the incoming attack from the enemy, recovering some health too");
						adventurer.setHealth(adventurer.getHealth()+5);
					}
					else {
						System.out.println(adventurer.getName()+" fails to parry the incoming attack!");
						enemyRoster.getItem(i).attack(adventurer);
					}
				}
				if (inp == 2) {
					if (adventurer.getPotionCount() > -1 && adventurer.getHealth() < adventurer.getMax()) {
						adventurer.usePotion();
						System.out.println(adventurer.getName()+" uses a healing potion! full health restored");
					}
					else if (adventurer.getHealth() >= adventurer.getMax()) {
						System.out.println(adventurer.getName()+"'s health is already at full capacity!");
					}
					else {
					System.out.println(adventurer.getName()+" has no healing potions left! what a pity!");
					}
					enemyRoster.getItem(i).attack(adventurer);
				}
			}
			if (i == 29) {
				System.out.println("Huzzah! praise be to "+adventurer.getName()+"!");
			}
			++i;
		}
		System.out.println("The end?");
		scnr.nextLine();
	}
	
}
