package main;

import main.character.*;
import main.character.Character;
import main.weaponBehavior.AxeBehavior;

public class AdventureGameSimulator {

    public static void main(String[] args) {
        Character knight = new Knight();
        knight.fight();

        knight.setWeapon(new AxeBehavior());
        knight.fight();

        Character king = King.getInstance();
        king.fight();

        Character queen = new Queen();
        queen.fight();

        Character troll = new Troll();
        troll.fight();
    }
}
