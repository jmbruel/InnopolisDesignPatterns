package game.characters;

import game.weapons.Sword;

public class Knight extends Character{

    public Knight(String name){
        super(name, Sword.getInstance());
    }
}
