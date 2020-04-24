package game.characters;

import game.weapons.Sword;

public class King extends Character {

    public King(String name){
        super(name, Sword.getInstance());
    }
}
