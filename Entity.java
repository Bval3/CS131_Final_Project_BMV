public class Entity {
    protected int health;
    protected int atkPower;
    protected int defPower;
    protected String attackLine;
    protected boolean isDead;

    public Entity() {
        this.health = 0;
        this.atkPower = 0;
        this.defPower = 0;
        this.attackLine = "";
        this.isDead = false;
    }

    public void attack(Entity e) {
        System.out.println(attackLine);
        int damage = getAtkPower() - e.getDefPower();
        e.setHealth(e.getHealth() - damage);
        System.out.println("The opponent's health is now at " + e.getHealth());
        if (e.getHealth() <= 0) {
            System.out.println("The opponent is slain");
            e.Death();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAtkPower() {
        return atkPower;
    }

    public void setAtkPower(int atkPower) {
        this.atkPower = atkPower;
    }

    public int getDefPower() {
        return defPower;
    }

    public void setDefPower(int defPower) {
        this.defPower = defPower;
    }

    public String getAttackLine() {
        return attackLine;
    }

    public void setAttackLine(String attackLine) {
        this.attackLine = attackLine;
    }

    public boolean getDead() {
        return isDead;
    }

    public void Death() {
        this.isDead = true;
    }
}
