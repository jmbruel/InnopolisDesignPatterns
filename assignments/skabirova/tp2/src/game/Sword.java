package game.weapons;

import game.Weapon;

public class Sword extends Weapon {

    private static Sword instance = new Sword();

    private Sword(){}

    public static Sword getInstance() {
        return instance;
    }

    @Override
    public String getWeaponName(){
        return "Sword";
    }
}
