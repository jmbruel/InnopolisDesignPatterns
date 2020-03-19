package Characters.impl;

import Characters.Character;
import Weapons.impl.Dagger;

public class Queen extends Character {
    public Queen() {
        super("Queen", Dagger.getInstance());
    }
}
