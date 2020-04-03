package game.weapons;

public class Bow implements Weapon {

	@Override
	public void attack() {
		System.out.println("Attack by bow.");
	}

	@Override
	public void defence() {
		System.out.println("Defence");
	}

}
