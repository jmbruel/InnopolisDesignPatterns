package appli;

import comportement.arme.impl.ComportementEpee;

public class Roi extends Personnage {
    public Roi() {
        comportementArme = ComportementEpee.getInstance();
    }
}