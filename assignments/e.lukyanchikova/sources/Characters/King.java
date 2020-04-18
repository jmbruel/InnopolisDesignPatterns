package sources.Characters;

import sources.Weapons.Sword;
import sources.Weapons.Weapon;

public class King extends CharacterU {
    private static King kingInstance= new King(new Sword());

    private King(Weapon weapon) {
        super(weapon);
    }



    public static King getKingInstance() {
        return kingInstance;
    }
}
