package comportement.arme.impl;

import comportement.arme.ComportementArme;

public class ComportementArc implements ComportementArme {

    private static ComportementArc instance = new ComportementArc();

    private ComportementArc() {
    }

    @Override
    public void utiliseArme() {
        System.out.println("J'utilise l'arc");
    }

    public static ComportementArc getInstance() {
        return instance;
    }
}