import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brian on 26/05/17.
 */
public class SpinnerTest {
    private Spinner spinner;

    @Before
    public void setUp() throws Exception {
        spinner = new Spinner();

    }

    @Test
    public void spinWords() throws Exception {
        assertEquals("Hey", spinner.spinWords("Hey"));
        assertEquals("emocleW", spinner.spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", spinner.spinWords("Hey fellow warriors"));
        assertEquals("This is a test", spinner.spinWords("This is a test"));
        assertEquals("This is rehtona test", spinner.spinWords("This is another test"));
        assertEquals("You are tsomla to the last test", spinner.spinWords("You are almost to the last test"));
        assertEquals("just gniddik ereht is llits one more", spinner.spinWords("just kidding there is still one more"));
    }

}