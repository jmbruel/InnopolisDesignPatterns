package main.character;

import main.weaponBehavior.KnifeBehavior;

public class Queen extends Character {

    public Queen() {
        this.weapon = new KnifeBehavior();
    }

    @Override
    public void fight() {
        System.out.print("Queen... ");
        this.weapon.useWeapon();
    }
}
