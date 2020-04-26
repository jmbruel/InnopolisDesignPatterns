package comportement.arme.impl;

import comportement.arme.ComportementArme;

public class ComportementPoignard implements ComportementArme {
    private static ComportementPoignard sharedInstance = new ComportementPoignard();

    private ComportementPoignard() {}

    @Override
    public void utiliseArme() {
        System.out.println("J'utilise le poignard");
    }

    public static ComportementPoignard getInstance() {
        return sharedInstance;
    }
}