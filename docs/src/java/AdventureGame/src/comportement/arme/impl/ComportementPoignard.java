package comportement.arme.impl;

import comportement.arme.ComportementArme;

public class ComportementPoignard implements ComportementArme {
	@Override
	public void utiliserArme() {
		System.out.println("Donne un coup de poignard");
	}
}
