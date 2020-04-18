package characters.implementation;

import characters.Character;
import weapons.implementation.Sword;

public class Knight extends Character {
    public Knight() {
        super(Sword.getInstance());
    }

    @Override
    public void fight() {
        System.out.println("I am a Knight!");
        super.fight();
    }

}