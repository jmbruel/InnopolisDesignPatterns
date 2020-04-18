package test;

import main.weaponBehavior.AxeBehavior;
import main.character.King;
import main.weaponBehavior.SwordBehavior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    void kingAsSingleton() {
        King kingOne = King.getInstance();
        King kingTwo = King.getInstance();

        Assertions.assertEquals(kingOne, kingTwo);
    }

    @Test
    void kingsWeaponChangeIsGlobal() {
        King kingOne = King.getInstance();
        kingOne.fight();
        Assertions.assertEquals(AxeBehavior.class, kingOne.weapon.getClass());
        kingOne.setWeapon(new SwordBehavior());
        Assertions.assertEquals(SwordBehavior.class, kingOne.weapon.getClass());

        King kingTwo = King.getInstance();
        Assertions.assertEquals(SwordBehavior.class, kingTwo.weapon.getClass());
    }
}
