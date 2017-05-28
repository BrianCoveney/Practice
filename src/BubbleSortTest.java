import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by brian on 28/05/17.
 */
public class BubbleSortTest {

    private BubbleSort bubbleSort;
    private int arrayLength1, arrayLength2;

    @Before
    public void setUp() throws Exception {

        bubbleSort = new BubbleSort();
        arrayLength1 = 10;
        arrayLength2 = 5;

    }

    @Test
    public void sort() throws Exception {

        assertEquals(Arrays.toString(new int[]{ 1, 1, 2, 5, 5, 13, 14, 15, 17, 20 }),
                Arrays.toString(bubbleSort.sort(new int[]{ 5, 20, 1, 1, 14, 15, 5, 17, 13, 2 }, arrayLength1)));


        assertEquals(Arrays.toString(new int[]{ 3, 5, 7, 8, 10, 11, 12, 12, 14, 18 }),
                Arrays.toString(bubbleSort.sort(new int[]{ 8, 18, 7, 10, 12, 14, 5, 11, 3, 12 }, arrayLength1)));


        assertEquals(Arrays.toString(new int[]{ 8, 9, 10, 16, 17 }),
                Arrays.toString(bubbleSort.sort(new int[]{ 17, 8, 10, 9, 16 }, arrayLength1)));

    }

}