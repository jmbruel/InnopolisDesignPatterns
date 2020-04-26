package appli;

import comportement.arme.impl.ComportementEpee;

public class Chevalier extends Personnage {
    public Chevalier() {
        arme = ComportementEpee.getInstance();
    }
}
