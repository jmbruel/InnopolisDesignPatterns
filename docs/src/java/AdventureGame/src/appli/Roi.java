package appli;

import comportement.arme.impl.ComportementArc;

public class Roi extends Personnage {
	public Roi() {
		super(new ComportementArc());
	}
}
