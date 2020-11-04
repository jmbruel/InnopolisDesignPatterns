package comportement.arme.impl;

import comportement.arme.ComportementArme;

public class ComportementArc implements ComportementArme {
	@Override
	public void utiliserArme() {
		System.out.println("Tire une flèche");
	}
}
