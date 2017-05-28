import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by brian on 27/05/17.
 */
public class AveragesTest {

    private AveragesOfNumbers averagesOfNumbers;

    @Before
    public void setUp() throws Exception {

        averagesOfNumbers = new AveragesOfNumbers();
    }

    @Test
    public void averages() throws Exception {


        assertEquals(Arrays.toString(new double[] { 2, 2, 2, 2 }),
                Arrays.toString(averagesOfNumbers.averages(new int[] { 2, 2, 2, 2, 2 })));


        assertEquals(Arrays.toString(new double[] { 0, 0, 0, 0 }), Arrays.toString(averagesOfNumbers.averages(new int[] { 2, -2, 2, -2, 2 })));
        assertEquals(Arrays.toString(new double[] { 2, 4, 3, -4.5 }), Arrays.toString(averagesOfNumbers.averages(new int[] { 1, 3, 5, 1, -10 })));

        assertEquals(Arrays.toString(new double[] { }), Arrays.toString(averagesOfNumbers.averages(new int[] { })));

        assertEquals(Arrays.toString(new double[] { }), Arrays.toString(averagesOfNumbers.averages(new int[] { 0 })));
        assertEquals(Arrays.toString(new double[] { }), Arrays.toString(averagesOfNumbers.averages(new int[] { 1 })));

    }

}