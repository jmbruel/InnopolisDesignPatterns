package comportement.arme.impl;

import comportement.arme.ComportementArme;

public class ComportementEpee implements ComportementArme {
	@Override
	public void utiliserArme() {
		System.out.println("Frappe à l'épée");
	}
}
