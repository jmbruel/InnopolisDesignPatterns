package game.characters;

import game.weapons.Weapon;

public abstract class Character {

    private String name;
    private Weapon weapon;

    protected Character(String name, Weapon weapon){
        this.name = name;
        this.weapon = weapon;
    }

    public String introduce(){
        return "My name is " + name +  ". My weapon is " + weapon.getWeaponName() + ".";
    }
}
