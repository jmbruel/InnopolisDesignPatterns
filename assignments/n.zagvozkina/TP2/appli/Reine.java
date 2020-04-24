package appli;

import comportements.impl.ComportementEpee;

public class Reine extends Personnage{
    public Reine()
    {
        this.setArme(ComportementEpee.getInstance());
    }

    public void combattre()
    {
        System.out.print("I am a Queen ");
        cptArm_.utiliseArme();
        System.out.println();
    }
}
