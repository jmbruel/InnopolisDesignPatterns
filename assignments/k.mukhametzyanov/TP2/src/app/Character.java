package app.characters;

import app.weapons.Weapon;

public abstract class Character {
    Weapon weapon;

    public void battle(){
        this.weapon.apply();
    }
}
