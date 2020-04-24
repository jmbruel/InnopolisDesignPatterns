package characters.implementation;

import characters.Character;
import weapons.implementation.Bow;

public class Troll extends Character {
    public Troll() {
        super(Bow.getInstance());
    }

    @Override
    public void fight() {
        System.out.println("I am a Troll!");
        super.fight();
    }

}