import java.util.Arrays;

/**
 * Created by brian on 28/05/17.
 */
public class BubbleSort {

    private int temp;
    int[] numbers;

    public BubbleSort() { }


    public int[] sort(int[] numberArrayInput, int arrLength) {

        numbers = new int[arrLength];

        numbers = numberArrayInput;
        System.out.println("\nOriginal:\n" + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("\nSorted:\n" + Arrays.toString(numbers));

        return numbers;
    }


    public void bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < numbers.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

















