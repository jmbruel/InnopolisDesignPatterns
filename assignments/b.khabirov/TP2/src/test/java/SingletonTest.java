import comportement.arme.impl.ComportementArc;
import comportement.arme.impl.ComportementEpee;
import comportement.arme.impl.ComportementPoignard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test
    public void testSingletonComportementEpee() {
        ComportementEpee comportementEpee1 = ComportementEpee.getInstance();
        ComportementEpee comportementEpee2 = ComportementEpee.getInstance();
        assertEquals(comportementEpee1, comportementEpee2);
    }

    @Test
    public void testSingletonComportementPoignard() {
        ComportementPoignard comportementPoignard1 = ComportementPoignard.getInstance();
        ComportementPoignard comportementPoignard2 = ComportementPoignard.getInstance();
        assertEquals(comportementPoignard1, comportementPoignard2);
    }

    @Test
    public void testComportementEpee() {
        ComportementArc comportementArc1 = ComportementArc.getInstance();
        ComportementArc comportementArc2 = ComportementArc.getInstance();
        assertEquals(comportementArc1, comportementArc2);
    }
}