package appli;

import comportement.arme.ComportementArme;

abstract public class Personnage {
    protected ComportementArme arme;

    public void setArme(ComportementArme a) {
        this.arme = a;
    }

    public void combattre() {
        this.arme.utiliseArme();
    }
}
