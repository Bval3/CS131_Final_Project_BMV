
public class Wizard extends Hero {
    public Wizard(String name) {
        this.name = name;
        health = 80;
        max = health;
        atkPower = 10;
        defPower = 3;
        attackLine = getName()+" chants an incantation, unleashing a powerful spell!";
        isDead = false;
    }
}
