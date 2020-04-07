package game;

public abstract class Personnage {
    private ComportementArme arme;

    public void combattre(){
        this.arme.utiliserArme();
    }

    public void setArme(ComportementArme arme){
        this.arme = arme;
    }
}

