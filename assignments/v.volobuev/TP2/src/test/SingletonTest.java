package test;

import comportement.arme.ComportementArme;
import comportement.arme.impl.ComportementArc;
import comportement.arme.impl.ComportementEpee;
import comportement.arme.impl.ComportementPoignard;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {
    @Test
    public void testSingletonComportementEpee() {
        ComportementArme c1 = ComportementEpee.getInstance();
        ComportementArme c2 = ComportementEpee.getInstance();
        assertEquals(c1, c2);
    }

    @Test
    public void testSingletonComportementPoignard() {
        ComportementArme c1 = ComportementPoignard.getInstance();
        ComportementArme c2 = ComportementPoignard.getInstance();
        assertEquals(c1, c2);
    }

    @Test
    public void testComportementEpee() {
        ComportementArme c1 = ComportementArc.getInstance();
        ComportementArme c2 = ComportementArc.getInstance();
        assertEquals(c1, c2);
    }

}
