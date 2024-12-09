import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        intro();
        select(scnr);
    }

    public static void intro() {
        System.out.println("--------------------");
        System.out.println("----DUNGEON=LORD----");
        System.out.println("--------------------");
        int i = 0;
        while (i < 3) {
            System.out.println("...");
            i++;
        }
        System.out.println("Welcome, adventurer!");
    }

    public static void select(Scanner scnr) {
        System.out.println("MAIN MENU:");
        System.out.println("1 - Start adventure");
        System.out.println("2 - Exit");
        int input = scnr.nextInt();
        scnr.nextLine();
        while (input != 2) {
        try {
            if (input == 1) {
            	String name, type;
                System.out.println("What kin art thou? A wizard, an elf, a human or a dwarf?");
                String inp = scnr.nextLine();
                Hero nh = new Hero();
                if (inp.equals("wizard") || inp.equals("Wizard")) {
                    type = "w";
                } else if (inp.equals("elf")|| inp.equals("Elf")) {
                    type = "e";
                } else if (inp.equals("human") || inp.equals("Human")) {
                    type = "h";
                } else {
                	type = "d";
                }
                System.out.println("What is thy name?");
                name = scnr.nextLine();

                if (type.equals("w")) {
                    nh = new Wizard(name);
                }
                if (type.equals("e")) {
                    nh = new Elf(name);
                }
                if (type.equals("h")) {
                    nh = new Human(name);
                }
                if (type.equals("d")) {
                    nh = new Dwarf(name);
                }
                System.out.println("So, you you are a " + inp + " named " + name + ", very well then. Fare thee well, hero..");
                Dungeon d = new Dungeon();
                d.entranceDialogue(nh);
                d.dungeonSimulation(nh, d, scnr);
        	}
            else {
            	throw new Exception("Invalid option selected, please try again");
            }
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
        	input = scnr.nextInt();
        	scnr.nextLine();
        }
        }
        System.out.println("Exited the dungeon simulator!");
    }
}
