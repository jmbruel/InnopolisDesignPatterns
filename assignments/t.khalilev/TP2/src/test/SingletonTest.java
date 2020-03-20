package test;

import comportement.arme.impl.ComportementArc;
import comportement.arme.impl.ComportementEpee;
import comportement.arme.impl.ComportementPoignard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test
    public void testSingletonComportementEpee() {
        ComportementEpee ce1 = ComportementEpee.getInstance();
        ComportementEpee ce2 = ComportementEpee.getInstance();
        assertEquals(ce1, ce2);
    }

    @Test
    public void testSingletonComportementPoignard() {
        ComportementPoignard cp1 = ComportementPoignard.getInstance();
        ComportementPoignard cp2 = ComportementPoignard.getInstance();
        assertEquals(cp1, cp2);
    }

    @Test
    public void testComportementEpee() {
        ComportementArc ca1 = ComportementArc.getInstance();
        ComportementArc ca2 = ComportementArc.getInstance();
        assertEquals(ca1, ca2);
    }
}
