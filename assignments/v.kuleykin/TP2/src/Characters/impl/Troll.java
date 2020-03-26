package Characters.impl;

import Characters.Character;
import Weapons.impl.Bow;

public class Troll extends Character {
    public Troll() {
        super("Troll", Bow.getInstance());
    }
}
