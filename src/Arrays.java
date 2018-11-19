
import static java.lang.Math.toIntExact;

import java.util.*;

public class Arrays {

    public static void main(String[] args) {

//        int[] nums = {9, 11, 90, 22, 6};
//        int[] arr = copyEndy2(nums, 2);
//
//        System.out.println("Array length: " + arr.length);
//        System.out.println(arr[0] + " " +arr[1]);

//        System.out.println(mergeWords(a, b));

        String a = "abckkk";
        String b = "def";

        System.out.println(mergeWords3(a, b));


//        System.out.println(reverse(-123));
//        System.out.println(reverse(2147483647));

//        System.out.println(oddNumbers(2, 5));

//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(1);
//
//        System.out.println(findNumber(list, 1));


//        int[] nums = { 3,3 };
//        int[] arr = twoSum(nums, 6);
//        System.out.println(arr[0] + " | " + arr[1]);


//        shiftLeft(nums);

        // fizzArray3(5, 10);
        //
        // System.out.println(reverseInt(1534236469));

        // System.out.println(sum28(nums));

        // System.out.println(lucky13(nums));

        // System.out.println(has22(nums));

        // System.out.println(sum67(nums));

        // System.out.println(centeredAverage(nums));

        // int[] nums = {10, 3, 5, 6};
        // int diff = bigDiff(nums);
        // System.out.println(diff);

        // System.out.println(hasOne(3));
        // int[] nums = {3, 4, 5, 1, 2, 3};
        // System.out.println(scoresAverage(nums));

        // String[] words = {"a", "bb", "b", "ccc"};
        // List<String> list = wordsWithoutList(words, 1);
        // System.out.println(list.toString());

        // int[] nums = {3, 4, 5, 1, 2, 3};
        // splitArrayInTwo(nums);

        // int[] nums = {3, 4, 6};
        // System.out.println("Increasing: " + scoresClump(nums));
    }



    static String mergeWords3(String a, String b) {
        String s = "";
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length() && i < b.length(); i++) {
                s += a.charAt(i);
                s += b.charAt(i);
            }
        } else {
            for (int i = 0; i < a.length(); i++) {
                s += a.charAt(i);
            }
            for (int i = 0; i < b.length(); i++) {
                s += b.charAt(i);
            }
        }
        return s;
    }

    static String mergeWords2(String a, String b) {
        String result = "";
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                result += a.charAt(i);
                result += b.charAt(i);
            }
        } else {
            if (a.length() > b.length()) {
                result = mergeUnequalStrings(a, b, a, b.length(), a.length());
            } else {
                result = mergeUnequalStrings(a, b, b, a.length(), b.length());
            }
        }
        return result;
    }

    private static String mergeUnequalStrings(String a, String b, String longerStr, int lengthShort, int lengthLong) {
        String result = "";
        for (int i = 0; i < lengthShort; i++) {
            result += a.charAt(i);
            result += b.charAt(i);
        }
        for (int j = lengthShort; j < lengthLong; j++) {
            result += longerStr.charAt(j);
        }

        return result;
    }

    static String mergeWords(String a, String b) {
        boolean isEqualLength = false;
        boolean isALonger = false;
        int aLength = a.length();
        int bLength = b.length();

        if (a.length() == b.length()) {
            isEqualLength = true;
        }

        if (aLength > bLength) {
            isALonger = true;
        }

        StringBuilder sb = new StringBuilder();
        if (isEqualLength) {
            for (int i = 0; i < aLength; i++) {
                sb.append(a.charAt(i));
                sb.append(b.charAt(i));
            }
        } else if (isALonger) {
            for (int i = 0; i < bLength; i++) {
                sb.append(a.charAt(i));
                sb.append(b.charAt(i));
            }
            for (int i = bLength; i < aLength; i++) {
                sb.append(a.charAt(i));
            }
        } else {
            for (int i = 0; i < aLength; i++) {
                sb.append(a.charAt(i));
                sb.append(b.charAt(i));
            }
            for (int i = aLength; i < bLength; i++) {
                sb.append(b.charAt(i));
            }
        }

        return sb.toString();
    }


    static int[] copyEndy(int[] nums, int count) {
        List<Integer> list = new ArrayList<>();
        int e = 1;
        for (int i = 0; i < nums.length; i++) {
            if (isEndy(nums[i])) {
                if (e <= count) {
                    list.add(nums[i]);
                    e++;
                }
            }
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    static int[] copyEndy2(int[] nums, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i <= count) {
                if (isEndy(num)) {
                    int endy = nums[i];
                    list.add(endy);
                }
            }
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        return arr;
    }

    public static int[] twoSum2Copy(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int leftNum = nums[i];
            int rightNum = target - leftNum;

            if (map.get(rightNum) != null) {
                result[0] = map.get(rightNum);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // O(n^2)
    public static int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                if ((first + second) == target) {
                    arr = new int[]{i, j};
                }
            }
        }
        return arr;
    }


    static boolean isEndy(int num) {
        boolean isNumEndy = false;
        if (num >= 0 && num <= 9 || num >= 90 && num <= 100) {
            isNumEndy = true;
        }
        return isNumEndy;
    }


    static int reverse(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num).reverse();
        String strRes = sb.toString();
        if (num < 0.0)
            strRes = strRes.charAt(strRes.length() - 1) + strRes.substring(0, strRes.length() - 1);

        long n = Long.parseLong(strRes);

        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            n = 0;
        }

        return (int) n;
    }


    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            System.out.println(i);
            list.add(i);
        }

        List<Integer> resList = new ArrayList<>();
        for (Integer e : list) {
            if (e % 2 != 0) {
                resList.add(e);
            }
        }

        return resList;
    }


    static String findNumber(List<Integer> arr, int k) {
        String result = "";
        boolean foundIt = false;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);

            if (num == k) {
                foundIt = true;
            }
        }
        if (foundIt) {
            result = "YES";
        } else {
            result = "NO";
        }
        return result;
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int leftNum = nums[i];
            int rightNum = target - leftNum;

            if (map.get(rightNum) != null) {
                result[0] = map.get(rightNum);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    // O(n^2)
//    public static int[] twoSum(int[] nums, int target) {
//        int[] arr = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            int first = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                int second = nums[j];
//                if ((first + second) == target) { ;
//                    arr = new int[] {i, j};
//                }
//            }
//        }
//        return arr;
//    }

    public static int[] shiftLeft(int[] nums) {
        int start = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[0];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        nums[nums.length - 1] = start;

        return nums;
    }

    private static int reverseInt(int num) {
        long res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        if (res > Integer.MAX_VALUE) {
            res = 0;
        }
        return toIntExact(res);
    }

    public static int[] fizzArray3(int start, int end) {
        int len = end - start;
        int[] arr = new int[len];
        for (int i = start, j = 0; i < end; i++, j++) {
            arr[j] = i;
        }
        return arr;
    }

    public static boolean tripleUp(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int one = nums[i];
            int two = nums[i + 1];
            int three = nums[i + 2];
            if ((two == (one + 1)) && (three == (two + 1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean sameEnds(int[] nums, int len) {
        int arrLength = nums.length;
        int rightIndex = arrLength - len;

        for (int i = 0; i < len; i++) {
            System.out.println(nums[rightIndex + i]);
        }
        return false;
    }

    private static int[] reverseArray(int[] arr, int left, int right) {
        for (int i = 0; i < right; i++) {
            int temp = arr[left];
            arr[left] = arr[right - 1];
            arr[right - 1] = temp;
        }
        return arr;
    }

    public static boolean twoTwo(int[] nums) {
        boolean isTwo = false;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i];
            int right = nums[i + 1];

            if (left == 2 && right == 2)
                isTwo = true;

            if (left != 2 && right == 2)
                isTwo = false;
        }
        return isTwo;
    }

    public static boolean haveThree(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                count++;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3 && nums[i + 1] == 3) {
                count--;
            }
        }
        return count == 3;
    }

    public static boolean modThree(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (first % 2 == 0 && second % 2 == 0 && third % 2 == 0) {
                return true;
            }
            if (first % 2 != 0 && second % 2 != 0 && third % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public static int matchUp(int[] nums1, int[] nums2) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int one = nums1[i];
            int two = nums2[i];
            int diff = 0;
            if (one > two) {
                diff = one - two;
            } else {
                diff = two - one;
            }
            if (diff <= 2 && one != two) {
                count++;
            }
        }
        return count;
    }

    public static boolean either24(int[] nums) {
        boolean isTwo = false;
        boolean isFour = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                isTwo = true;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 4 && nums[i + 1] == 4) {
                isFour = true;
            }
        }

        if (isTwo && isFour) {
            return false;
        }

        return false;
    }

    public static boolean isEverywhere(int[] nums, int target) {

        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != target)
                flag1 = false;

            boolean isTwo = nums[i] == 2 && nums[i + 1] == 2;

        }
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i + 1] != target)
                flag2 = false;
        }
        return flag1 || flag2;
    }

    public static boolean sum28(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                sum += nums[i];
            }
        }
        if (sum == 8) {
            return true;
        }
        return false;
    }

    public static boolean lucky13(int[] nums) {
        boolean hasNums = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 3) {
                hasNums = false;
            }

        }
        return hasNums;
    }

    public static boolean has22(int[] nums) {
        boolean isMatch = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                isMatch = true;
            }
        }
        return isMatch;

    }

    public static int sum67(int[] nums) {
        int sum = 0;
        boolean inRange = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6) {
                inRange = true;
            }
            if (!inRange) {
                sum += nums[i];
            }
            if (inRange && nums[i] == 7) {
                inRange = false;
            }
        }

        return sum;
    }

    public static int centeredAverage(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : nums) {
            list.add(integer);
        }

        list.remove(list.indexOf(Collections.min(list)));
        list.remove(list.indexOf(Collections.max(list)));

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum / list.size();
    }

    public static int removeFirstAndLast(int[] nums) {
        int sum = 0;
        List<Integer> numsList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        numsList.remove(numsList.get(0));
        numsList.remove(numsList.get(numsList.size() - 1));
        for (int i = 0; i < numsList.size(); i++) {
            sum += numsList.get(i);
        }
        return sum / numsList.size();
    }

    public static int bigDiff(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (smallest > nums[i]) {
                smallest = nums[i];
            }
            if (largest < nums[i]) {
                largest = nums[i];
            }
        }
        return largest - smallest;
    }

    public static boolean hasOne(int n) {
        while (n != 0) {
            if (n % 2 == 0) {
                return true;
            }

            n /= 10;
        }

        return false;
    }

    public static List wordsWithoutList(String[] words, int len) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == len) {
                list.remove(list.get(i));
            }
        }
        return list;
    }

    public static int scoresAverage(int[] scores) {
        int middle = scores.length / 2;
        int avgFirst = average(scores, 0, middle);
        int avgSecond = average(scores, middle, scores.length);

        if (avgFirst > avgSecond) {
            return avgFirst;
        }
        return avgSecond;
    }

    public static int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += scores[i];
        }
        return sum / (end - start);
    }

    // Second half is copied with an index of 0 for the new array and index of
    // middle for the existing
    public static void splitArrayInTwo(int[] scores) {
        int middle = scores.length / 2;
        int end = scores.length - 1;

        int[] firstHalf = new int[middle];
        int[] secondHalf = new int[middle];

        System.out.println("First half of array:");
        for (int i = 0; i < middle; i++) {
            firstHalf[i] = scores[i];
        }

        System.out.println("Second half of array:");
        for (int i = 0, j = middle; j <= end; j++, i++) {
            secondHalf[i] = scores[j];
        }
    }

    // Q3
    public static boolean scoresClump(int[] scores) {
        for (int i = 0; i < scores.length - 2; i++) {
            int range = scores[i + 2] - scores[i];
            if (range <= 2) {
                return true;
            }
        }
        return false;
    }// end Q3

}
