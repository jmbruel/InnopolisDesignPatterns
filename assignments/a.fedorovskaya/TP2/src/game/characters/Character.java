package game.characters;

import game.weapons.Weapon;

public abstract class Character {
    Weapon weapon;

    public void battle(){
        this.weapon.use();
    }
}