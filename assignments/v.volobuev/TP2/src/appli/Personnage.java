package appli;

import comportement.arme.ComportementArme;

abstract public class Personnage {
    protected ComportementArme comportementArme;

    public void setArme(ComportementArme ca) {
        this.comportementArme = ca;
    }

    public void combattre() {
        this.comportementArme.utiliseArme();
    }

}
