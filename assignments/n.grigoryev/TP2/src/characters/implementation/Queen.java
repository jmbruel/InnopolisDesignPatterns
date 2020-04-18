package characters.implementation;

import characters.Character;
import weapons.implementation.Dagger;

public class Queen extends Character {
    public Queen() {
        super(Dagger.getInstance());
    }

    @Override
    public void fight() {
        System.out.println("I am a Queen!");
        super.fight();
    }
}