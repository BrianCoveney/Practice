import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {

    Logic logic = new Logic();

    @Test
    public void withoutDoubles() throws Exception {
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

    @Test
    public void maxMod5() throws Exception {
        assertEquals(3, logic.maxMod5(2, 3));
        assertEquals(6, logic.maxMod5(6, 2));
        assertEquals(3, logic.maxMod5(3, 2));
        assertEquals(12, logic.maxMod5(8, 12));
        assertEquals(7, logic.maxMod5(7, 12));
        assertEquals(6, logic.maxMod5(11, 6));
        assertEquals(2, logic.maxMod5(2, 7));
        assertEquals(0, logic.maxMod5(7, 7));
        assertEquals(9, logic.maxMod5(9, 1));
        assertEquals(9, logic.maxMod5(9, 14));
        assertEquals(2, logic.maxMod5(1, 2));
    }


    @Test
    public void redTicket() throws Exception {
        assertEquals(10, logic.redTicket(2,2,2));
        assertEquals(0, logic.redTicket(2, 2, 1));
        assertEquals(5, logic.redTicket(0, 0, 0));
        assertEquals(1, logic.redTicket(2, 0, 0));
        assertEquals(5, logic.redTicket(1, 1, 1));
        assertEquals(0, logic.redTicket(1, 2, 1));
        assertEquals(1, logic.redTicket(1, 2, 0));
        assertEquals(1, logic.redTicket(0, 2, 2));
        assertEquals(1, logic.redTicket(1, 2, 2));
        assertEquals(0, logic.redTicket(0, 2, 0));
        assertEquals(0, logic.redTicket(1, 1, 2));
    }


    @Test
    public void greenTicket() throws Exception {
        assertEquals(0, logic.greenTicket(1, 2, 3));
    }


}