package app.weapons;


public class Sword implements Weapon {
    public Sword(){}

    @Override
    public void apply(){
        System.out.println("Apply sword");
    }
}