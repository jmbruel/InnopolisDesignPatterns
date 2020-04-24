package app.characters;

import app.weapons.Bow;
import app.weapons.Weapon;

public class Queen extends Character {
    private static Queen queen = new Queen(new Bow());

    public Queen(Weapon weapon){
        this.weapon = weapon;
    }

    public static Queen getInstance() {
        return queen;
    }
}