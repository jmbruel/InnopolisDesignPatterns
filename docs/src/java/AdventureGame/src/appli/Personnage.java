package appli;

import comportement.arme.ComportementArme;

public abstract class Personnage {
	private ComportementArme arme;
	
	public Personnage(ComportementArme armeParDefaut) {
		arme = armeParDefaut;
	}
	
	public void combattre() {
		arme.utiliserArme();
	}
	
	public void setArme(ComportementArme a) {
		this.arme = a;
	}
}
