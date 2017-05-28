import java.util.Arrays;

/**
 * Created by brian on 26/05/17.
 */
public class AveragesOfNumbers {

    public AveragesOfNumbers() { }

    public double[] averages(int[] numbers)
    {
        double add;
        double average;
        double[] arrayAverages;

        if( numbers == null || numbers.length < 2) {
            arrayAverages = new double[0];
        }
        else {
            arrayAverages = new double[numbers.length - 1];
        }


        for (int i = 0; i < arrayAverages.length; i++) {
            int curr = numbers[i];
            int next = numbers[i+1];

            add = curr + next;
            average = add / 2;
            arrayAverages[i] = average;
        }

        System.out.println(Arrays.toString(arrayAverages));
        return arrayAverages;
    }

}














