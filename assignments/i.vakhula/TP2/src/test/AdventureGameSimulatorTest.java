package test;

import main.character.*;
import main.character.Character;
import main.weaponBehavior.AxeBehavior;
import main.weaponBehavior.BowAndArrowBehavior;
import main.weaponBehavior.KnifeBehavior;
import main.weaponBehavior.SwordBehavior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdventureGameSimulatorTest {

    @Test
    void checkDefaultWeapons() {
        Character knight = new Knight();
        Assertions.assertEquals(SwordBehavior.class, knight.weapon.getClass());
        Assertions.assertNotEquals(AxeBehavior.class, knight.weapon.getClass());
        Assertions.assertNotEquals(BowAndArrowBehavior.class, knight.weapon.getClass());
        Assertions.assertNotEquals(KnifeBehavior.class, knight.weapon.getClass());

        Character king = King.getInstance();
        Assertions.assertEquals(AxeBehavior.class, king.weapon.getClass());

        Character queen = new Queen();
        Assertions.assertEquals(KnifeBehavior.class, queen.weapon.getClass());

        Character troll = new Troll();
        Assertions.assertEquals(BowAndArrowBehavior.class, troll.weapon.getClass());
    }

    @Test
    void checkCharacterDynamicWeaponChange() {
        // troll's default weapon is bow and arrows
        Character troll = new Troll();
        Assertions.assertEquals(BowAndArrowBehavior.class, troll.weapon.getClass());

        // troll kills knight and takes their weapon
        troll.setWeapon(new SwordBehavior());
        Assertions.assertEquals(SwordBehavior.class, troll.weapon.getClass());

        // troll understands that sword is not easy to use and takes bow and arrows back
        troll.setWeapon(new BowAndArrowBehavior());
        Assertions.assertEquals(BowAndArrowBehavior.class, troll.weapon.getClass());
    }

}
