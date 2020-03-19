package Characters.impl;

import Characters.Character;
import Weapons.impl.Sword;

public class King extends Character {
    public King() {
        super("King", Sword.getInstance());
    }
}
