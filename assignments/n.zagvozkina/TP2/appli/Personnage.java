package appli;

import comportements.ComportementArme;

public class Personnage {
    protected ComportementArme cptArm_;

    public void setArme(ComportementArme cptArm)
    {
        cptArm_ = cptArm;
    }
    public void combattre(){
        cptArm_.utiliseArme();
    };
}
