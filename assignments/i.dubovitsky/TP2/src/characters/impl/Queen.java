package characters.impl;

import characters.Character;
import weapons.impl.DaggerBehaviour;

public class Queen extends Character{
    public Queen() {
        super(DaggerBehaviour.getInstance());
    }
}
