package comportements.impl;

import comportements.ComportementArme;

public class ComportementPoignard implements ComportementArme {
    private static ComportementPoignard instance = new ComportementPoignard();
    @Override
    public void utiliseArme()
    {
        System.out.print("I'll stick a dagger in your back.");
    }
    public static ComportementPoignard getInstance() {
        return instance;
    }
}
