import java.util.*;

public class Pairs {

    public static void main(String[] args) {

        // There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1].
        int[] arr = {1, 5, 3, 4, 2, 5};
        System.out.println(pairs2(2, arr)); // = 3
    }

    // This algorithm runs in O(n^2)
    // - 1. Sort the array = O(N log N)
    // - 2. Run a nested loop to check if the difference between two array numbers is equal to the target = O(n^2)
    // - 3. Increment and return count
    static int pairs(int target, int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = i + 1; j < array.length; j++)
                if (array[j] - array[i] == target)
                    count++;
        return count;
    }

    // This algorithm runs in O(n)
    // - 1. Add array of numbers to a HashSet
    // - 2. Run loop over HashSet to check if the set contains the difference between each array number and the target
    // - 3. Increment and return count
    static int pairs2(int target, int[] array) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < array.length; i++)
            numSet.add(array[i]);

        int count = 0;
        for (int i = 0; i < numSet.size(); i++)
            if (numSet.contains(array[i] - target))
                count++;
        return count;
    }

}








