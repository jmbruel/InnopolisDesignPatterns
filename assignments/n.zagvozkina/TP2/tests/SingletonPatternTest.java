package tests;

import comportements.impl.ComportementEpee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonPatternTest {
    @Test
    public void testSingletonComportementEpee() {
        ComportementEpee comportementEpee1 = ComportementEpee.getInstance();
        ComportementEpee comportementEpee2 = ComportementEpee.getInstance();
        assertEquals(comportementEpee1, comportementEpee2);
    }
}
