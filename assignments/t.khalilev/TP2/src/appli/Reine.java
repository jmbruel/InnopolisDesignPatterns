package appli;

import comportement.arme.impl.ComportementArc;

public class Reine extends Personnage {
    public Reine() {
        comportementArme = ComportementArc.getInstance();
    }
}
