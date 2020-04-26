package appli;

import comportement.arme.impl.ComportementPoignard;

public class Troll extends Personnage{
    public Troll() {
        arme = ComportementPoignard.getInstance();
    }
}