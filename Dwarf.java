
public class Dwarf extends Hero{
	public Dwarf (String name) {
		this.name = name;
		health = 90;
		max = health;
        atkPower = 10;
        defPower = 10;
        attackLine = getName()+" swings their weapon, landing a devastating blow!";
        isDead = false; 
	}
		

}
