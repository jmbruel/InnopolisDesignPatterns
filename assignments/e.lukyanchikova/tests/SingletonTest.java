package tests;

import sources.Characters.King;
import sources.Characters.Queen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test
    public void TestKing() {
        King king = King.getKingInstance();
        King anotherKing = King.getKingInstance();
        assertEquals(king, anotherKing);
    }

    @Test
    public void TestQueen() {
        Queen queen = Queen.getQueenInstanse();
        Queen anotherQueen = Queen.getQueenInstanse();
        assertEquals(queen, anotherQueen);
    }
}
