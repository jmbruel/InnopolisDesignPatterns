package game.characters;

import game.weapons.Dagger;

public class Queen extends Character {

    public Queen(String name){
        super(name,  Dagger.getInstance());
    }
}
