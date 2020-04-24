package main.character;

import main.weaponBehavior.AxeBehavior;

public class King extends Character {

    private static King king = new King();

    private King() {
        this.weapon = new AxeBehavior();
    }

    public static King getInstance() {
        return king;
    }

    @Override
    public void fight() {
        System.out.print("King... ");
        this.weapon.useWeapon();
    }
}
