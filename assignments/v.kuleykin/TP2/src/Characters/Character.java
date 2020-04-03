package Characters;

import Weapons.WeaponBehavior;

public abstract class Character {

    private String name;
    private WeaponBehavior weapon;

    protected Character(String name, WeaponBehavior weapon){
        this.name = name;
        this.weapon = weapon;
    }

    public String introduce() {
        return String.format("I am %s. My weapon is %s.", name, weapon.getWeaponName());
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}
