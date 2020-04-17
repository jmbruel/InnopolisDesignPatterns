package main.character;

import main.weaponBehavior.BowAndArrowBehavior;

public class Troll extends Character {

    public Troll() {
        this.weapon = new BowAndArrowBehavior();
    }

    @Override
    public void fight() {
        System.out.print("Troll... ");
        this.weapon.useWeapon();
    }
}
