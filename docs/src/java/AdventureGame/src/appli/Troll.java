package appli;

import comportement.arme.impl.ComportementEpee;

public class Troll extends Personnage {
	public Troll() {
		super(new ComportementEpee());
	}
}
