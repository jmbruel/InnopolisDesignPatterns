package game.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.characters.King;

class KingTest {

	@Test
	void test1() {
		King king1 = King.getKing();
		King king2 = King.getKing();
		
		assertEquals(king1, king2);
	}
}
