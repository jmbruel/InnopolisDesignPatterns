package game.characters;

import game.weapons.Sword;

public class King extends Character {
	private static King instance = new King();
	
	private King() {
		weapon = new Sword();
	}
	
	public static final King getKing() {
		if (instance == null) {
			instance = new King();
		}
		return instance;
	}

}
