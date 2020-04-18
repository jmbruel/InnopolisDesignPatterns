package sources.Characters;

import sources.Weapons.Bow;
import sources.Weapons.Weapon;

public class Queen extends CharacterU {
    private static Queen queenInstanse = new Queen(new Bow());

    private Queen(Weapon weapon) {
        super(weapon);
    }

    public static Queen getQueenInstanse() {
        return queenInstanse;
    }
}
