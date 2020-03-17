package game.weapons;

public class Knife implements Weapon {

	@Override
	public void attack() {
		System.out.println("Attack by knife.");
	}

	@Override
	public void defence() {
		System.out.println("Defence");
	}

}
