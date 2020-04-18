package test;

import org.junit.jupiter.api.Test;
import weapons.implementation.Bow;
import weapons.implementation.Dagger;
import weapons.implementation.Sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonPatternTest {
    @Test
    public void testSingletonSword() {
        Sword swordOne = Sword.getInstance();
        Sword swordTwo = Sword.getInstance();
        assertEquals(swordOne, swordTwo);
    }

    @Test
    public void testSingletonDagger() {
        Dagger daggerOne = Dagger.getInstance();
        Dagger daggerTwo = Dagger.getInstance();
        assertEquals(daggerOne, daggerTwo);
    }

    @Test
    public void testSingletonAxe() {
        Bow bowOne = Bow.getInstance();
        Bow bowTwo = Bow.getInstance();
        assertEquals(bowOne, bowTwo);
    }
}