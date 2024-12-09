
public class Hero extends Entity{
	protected String name; 
	protected int max;
	protected Roster<Potion> potionHolder = new Roster<Potion>(3);
	protected int potionCount;
	
	public Hero() {
		name = "Hero_Placeholder";
		health = 0;
		max = health;
        atkPower = 0;
        defPower = 0;
        attackLine = "The Hero attacks bravely!";
        isDead = false;
        fillHolder();
        potionCount = 2;    
	}

	@Override
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
	
	public void usePotion() {
		potionHolder.getItem(getPotionCount()).heal(this);
		potionCount--;
	}
	public void fillHolder() {
		for (int i = 0; i < 3; ++i) {
			potionHolder.addItem(new Potion());
		}
	}
	/**
	 * @return the potionCount
	 */
	public int getPotionCount() {
		return potionCount;
	}

	/**
	 * @param potionCount the potionCount to set
	 */
	public void setPotionCount(int potionCount) {
		this.potionCount = potionCount;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	
}
