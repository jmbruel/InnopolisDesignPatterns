package appli;

import comportement.arme.impl.ComportementPoignard;

public class Reine extends Personnage {
	public Reine() {
		super(new ComportementPoignard());
	}
}
