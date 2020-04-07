package test;

import game.characters.King;
import game.characters.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Singleton {
    @Test
    public void TestKing() {
        King king1 = King.getInstance();
        King king2 = King.getInstance();
        assertEquals(king1, king2);
    }

    @Test
    public void TestQueen() {
        Queen queen1 = Queen.getInstance();
        Queen queen2 = Queen.getInstance();
        assertEquals(queen1, queen2);
    }

}
