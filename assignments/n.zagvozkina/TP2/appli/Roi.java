package appli;

import comportements.impl.ComportementEpee;

public class Roi extends Personnage{
    public Roi()
    {
        this.setArme(ComportementEpee.getInstance());
    }

    public void combattre()
    {
        System.out.print("I am a King ");
        cptArm_.utiliseArme();
        System.out.println();
    }
}
