package main.character;

import main.weaponBehavior.WeaponBehavior;

abstract public class Character {

    public WeaponBehavior weapon;

    public abstract void fight();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}
