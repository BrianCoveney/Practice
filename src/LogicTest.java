import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {



    @Test
    public void withoutDoubles() throws Exception {
        Logic logic = new Logic();

        assertEquals(5, logic.withoutDoubles(2, 3, true));
        assertEquals(7, logic.withoutDoubles(3, 3, true));
        assertEquals(6, logic.withoutDoubles(3, 3, false));
        assertEquals(5, logic.withoutDoubles(2, 3, false));
        assertEquals(9, logic.withoutDoubles(5, 4, true));
        assertEquals(9, logic.withoutDoubles(5, 4, false));
        assertEquals(11, logic.withoutDoubles(5, 5, true));
        assertEquals(10, logic.withoutDoubles(5, 5, false));
        assertEquals(7, logic.withoutDoubles(6, 6, true));
        assertEquals(12, logic.withoutDoubles(6, 6, false));
        assertEquals(7, logic.withoutDoubles(1, 6, true));
        assertEquals(7, logic.withoutDoubles(6, 1, false));
    }


}