package characters.impl;

import characters.Character;
import weapons.impl.AxeBehaviour;

public class Troll extends Character {
    public Troll() {
        super(AxeBehaviour.getInstance());
    }

}
