
public class Enemy extends Entity {
	protected String announce; 
	Enemy () {
		announce = "An enemy appears!";
        health = 0;
        atkPower = 0;
        defPower = 0;
        attackLine = "The enemy attacks";
        isDead = false; 
	}
	
	@Override
    public void attack(Entity e) {
        System.out.println(attackLine);
        int damage = getAtkPower() - e.getDefPower();
        System.out.println("Damage dealt: "+damage);
        if (damage <= 0) {
        	System.out.println("the attack was nullified by your defense points!");
        }
        else if (damage > 0) {
           e.setHealth(e.getHealth() - damage);

        }
        System.out.println("your health is now at "+e.getHealth());
        if (e.getHealth() <= 0) {
            System.out.println("you have been slain!");
            System.out.println("...The end?");
            e.Death();
        }
    }
	
	/**
	 * @return the announce
	 */
	public String getAnnounce() {
		return announce;
	}
	/**
	 * @param announce the announce to set
	 */
	public void setAnnounce(String announce) {
		this.announce = announce;
	}
	

    

}
