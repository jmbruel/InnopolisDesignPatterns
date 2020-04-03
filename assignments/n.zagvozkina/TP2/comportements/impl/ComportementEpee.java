package comportements.impl;

import comportements.ComportementArme;

public class ComportementEpee implements ComportementArme {
    private static ComportementEpee instance = new ComportementEpee();

    @Override
    public void utiliseArme() {
        System.out.print("Don't make me pull out my big sword.");
    }

    public static ComportementEpee getInstance() {
        return instance;
    }
}
