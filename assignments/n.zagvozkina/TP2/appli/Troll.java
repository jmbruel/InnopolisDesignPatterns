package appli;

import comportements.impl.ComportementEpee;

public class Troll extends Personnage{
    public Troll()
    {
        this.setArme(ComportementEpee.getInstance());
    }

    public void combattre()
    {
        System.out.print("I am a Troll ");
        cptArm_.utiliseArme();
        System.out.println();
    }
}
