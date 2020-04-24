package appli;

import comportements.impl.ComportementEpee;

public class Chevalier extends Personnage {
    public Chevalier()
    {
         this.setArme(ComportementEpee.getInstance());
    }

    @Override
    public void combattre()
    {
        System.out.print("I'm a Knight ");
        cptArm_.utiliseArme();
        System.out.println();
    }
}
