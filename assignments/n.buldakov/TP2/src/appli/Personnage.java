package appli;

import comportement.arme.ComportementArme;

abstract public class Personnage {
    protected ComportementArme comportementArme;

    public void setArme(ComportementArme a) {
        this.comportementArme = a;
    }

    public void combattre() {
        this.comportementArme.utiliseArme();
    }


}
