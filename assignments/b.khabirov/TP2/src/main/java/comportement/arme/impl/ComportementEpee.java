package comportement.arme.impl;

import comportement.arme.ComportementArme;

public class ComportementEpee implements ComportementArme {
    private static ComportementEpee sharedInstance = new ComportementEpee();

    private ComportementEpee() {}

    @Override
    public void utiliseArme() {
        System.out.println("J'utilise l'épée");
    }

    public static ComportementEpee getInstance() {
        return sharedInstance;
    }
}