package simuaventure.comportements.arme.impl;

import simuaventure.comportements.arme.ComportementArme;

public class ComportementArc implements ComportementArme {

	private int nbFleche = 10;

	@Override
	public void attaque() {
		if (estOperationnelle()) {
			System.out.println("Tire une fl�che");
			nbFleche--;
		}
	}

	@Override
	public boolean estOperationnelle() {
		// TODO Auto-generated method stub
		return nbFleche > 0;
	}

}
