import weapons.impl.AxeBehaviour;
import weapons.impl.SwordBehaviour;
import weapons.impl.DaggerBehaviour;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonPatternTest {
    @Test
    public void testSingletonAxeBehaviour() {
        AxeBehaviour axeBehaviour1 = AxeBehaviour.getInstance();
        AxeBehaviour axeBehaviour2 = AxeBehaviour.getInstance();
        assertEquals(axeBehaviour1, axeBehaviour2);
    }

    @Test
    public void testSingletonSwordBehaviour() {
        SwordBehaviour swordBehaviour1 = SwordBehaviour.getInstance();
        SwordBehaviour swordBehaviour2 = SwordBehaviour.getInstance();
        assertEquals(swordBehaviour1, swordBehaviour2);
    }

    @Test
    public void testSingletonDaggerBehaviour() {
        DaggerBehaviour daggerBehaviour1 = DaggerBehaviour.getInstance();
        DaggerBehaviour daggerBehaviour2 = DaggerBehaviour.getInstance();
        assertEquals(daggerBehaviour1, daggerBehaviour2);
    }
}
