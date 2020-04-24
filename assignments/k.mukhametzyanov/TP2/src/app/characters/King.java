package app.characters;

import app.weapons.Sword;
import app.weapons.Weapon;

public class King extends Character {
    private static King king = new King(new Sword());

    private King(Weapon weapon){
        this.weapon = weapon;
    }

    public static King getInstance() {
        return king;
    }
}