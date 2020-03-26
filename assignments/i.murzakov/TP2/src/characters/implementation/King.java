package characters.implementation;

import characters.Character;
import weapons.implementation.Sword;

public class King extends Character {
    public King() {
        super(Sword.getInstance());
    }

    @Override
    public void fight() {
        System.out.println("I am a King!");
        super.fight();
    }

}