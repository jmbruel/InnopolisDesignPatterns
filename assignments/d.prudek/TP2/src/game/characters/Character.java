package game.characters;

import game.weapons.Weapon;

public abstract class Character {
	protected Weapon weapon;
	private int health;
	
	public void attack() {
		weapon.attack();
	}
	public void defence() {
		weapon.defence();
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
