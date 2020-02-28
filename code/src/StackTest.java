import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testEmpty() {
        Stack s = new Stack();
        assertEquals(s.size(), 0);
    }

}