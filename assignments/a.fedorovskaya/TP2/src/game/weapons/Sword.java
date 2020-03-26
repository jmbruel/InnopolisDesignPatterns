package game.weapons;


public class Sword implements Weapon {

    public Sword(){}

    @Override
    public void use(){
        System.out.println("Smash with sword!");
    }
}