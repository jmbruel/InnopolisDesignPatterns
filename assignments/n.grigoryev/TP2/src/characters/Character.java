package characters;

import weapons.Weapon;

abstract public class Character {
    protected Weapon weapon;

    protected Character(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void fight() {
        weapon.use();
    }
}