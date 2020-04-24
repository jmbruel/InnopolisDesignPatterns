package appli;

import comportements.ComportementArme;
import comportements.impl.ComportementArc;
import comportements.impl.ComportementEpee;
import comportements.impl.ComportementPoignard;

class Main
{
    public static void main (String[] args)
    {
        ComportementArme cptPoign = new ComportementPoignard();
        ComportementArme cptEpee = new ComportementEpee();
        ComportementArme cptArc = new ComportementArc();

        Personnage chevalier = new Chevalier();
        Personnage roi = new Roi();
        Personnage reine = new Reine();
        Personnage troll = new Troll();

        chevalier.combattre();
        roi.combattre();
        reine.combattre();

        chevalier.setArme(cptPoign);
        roi.setArme(cptArc);
        reine.setArme(cptEpee);

        chevalier.combattre();
        roi.combattre();
        reine.combattre();


    }
}
