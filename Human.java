
public class Human extends Hero {
    public Human(String name) {
        this.name = name;
        health = 90;
        max = health;
        atkPower = 12;
        defPower = 7;
        attackLine = getName()+" charges forward and strikes with precision!";
        isDead = false;
    }
}

