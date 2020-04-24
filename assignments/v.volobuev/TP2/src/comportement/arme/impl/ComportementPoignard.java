package comportement.arme.impl;

import comportement.arme.ComportementArme;

public class ComportementPoignard implements ComportementArme {

    private static ComportementPoignard instance = new ComportementPoignard();

    private ComportementPoignard() {
    }

    @Override
    public void utiliseArme() {
        System.out.println("Using poignard");
    }

    public static ComportementPoignard getInstance() {
        return instance;
    }
}
