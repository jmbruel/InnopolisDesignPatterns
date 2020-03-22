package characters.impl;

import characters.Character;
import weapons.impl.SwordBehaviour;

public class Knight extends Character {
    public Knight() {
        super(SwordBehaviour.getInstance());
    }

}
