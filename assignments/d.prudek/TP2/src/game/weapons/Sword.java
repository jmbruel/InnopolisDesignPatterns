package game.weapons;

public class Sword implements Weapon {

	@Override
	public void attack() {
		System.out.println("Attack by sword.");
	}

	@Override
	public void defence() {
		System.out.println("Defence");
	}

}
