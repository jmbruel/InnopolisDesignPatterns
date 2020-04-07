package game.characters;

import game.weapons.Bow;

public class Troll extends Character {

    public Troll(String name){
        super(name, Bow.getInstance());
    }
}
