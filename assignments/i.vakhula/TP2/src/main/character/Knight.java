package main.character;

import main.weaponBehavior.SwordBehavior;

public class Knight extends Character {

    public Knight() {
        this.weapon = new SwordBehavior();
    }

    @Override
    public void fight() {
        System.out.print("Knight... ");
        this.weapon.useWeapon();
    }
}
