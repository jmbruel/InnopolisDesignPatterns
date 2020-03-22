package characters.impl;

import characters.Character;
import weapons.impl.SwordBehaviour;

public class King extends Character {
    public King() {
        super(SwordBehaviour.getInstance());
    }

}
