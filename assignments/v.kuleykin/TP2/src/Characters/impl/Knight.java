package Characters.impl;

import Characters.Character;
import Weapons.impl.Sword;

public class Knight extends Character {
    public Knight() {
        super("Knight", Sword.getInstance());
    }
}
