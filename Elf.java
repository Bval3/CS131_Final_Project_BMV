
public class Elf extends Hero {
    public Elf(String name) {
        this.name = name;
        health = 90;
        max = health;
        atkPower = 9;
        defPower = 4;
        attackLine = getName()+" gracefully fires a deadly arrow from their bow!";
        isDead = false;
    }
}
