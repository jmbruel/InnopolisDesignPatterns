import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testEmpty() {
        Stack s = new Stack();
        assertEquals(0,s.size());
    }

    @Test
    public void testEmptyConstructor() {
        Stack s = new Stack();
        assertEquals(0,s.size());
    }

    @Test
    public void testArrayListConstructor() {
        ArrayList<Integer> testAList = new ArrayList<Integer>();
        testAList.add(2);
        testAList.add(2);
        testAList.add(8);

        Stack s = new Stack(testAList);
        assertEquals( 3, s.size());
    }

}