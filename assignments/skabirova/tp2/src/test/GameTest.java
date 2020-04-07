package test;

import game.characters.King;
import game.characters.Knight;
import game.characters.Queen;
import game.characters.Troll;
import org.junit.jupiter.api.*;
import game.weapons.Bow;
import game.weapons.Dagger;
import game.weapons.Sword;

public class GameTest {
    @Test
    public void testSword(){
        Sword sword1 = Sword.getInstance();
        Sword sword2 = Sword.getInstance();
        Assertions.assertEquals(sword1, sword2);
    }

    @Test
    public void testDagger(){
        Dagger dagger1 = Dagger.getInstance();
        Dagger dagger2 = Dagger.getInstance();
        Assertions.assertEquals(dagger1, dagger2);
    }

    @Test
    public void testBow(){
        Bow bow1 = Bow.getInstance();
        Bow bow2 = Bow.getInstance();
        Assertions.assertEquals(bow1, bow2);
    }

    @Test
    public void testKnight(){
        Knight knight = new Knight("Derek");
        Assertions.assertEquals("My name is Derek. My weapon is Sword.", knight.introduce());
    }

    @Test
    public void testQueen(){
        Queen queen = new Queen("Elena");
        Assertions.assertEquals("My name is Elena. My weapon is Dagger.", queen.introduce());
    }

    @Test
    public void testKing(){
        King king = new King("Robert");
        Assertions.assertEquals("My name is Robert. My weapon is Sword.", king.introduce());
    }

    @Test
    public void testTroll(){
        Troll troll = new Troll("BugaBuga");
        Assertions.assertEquals("My name is BugaBuga. My weapon is Bow.", troll.introduce());
    }
}
