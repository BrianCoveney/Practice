import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MissingLetterTest {


    public char findMissingLetter(char[] inputArray) {

        char[] alphabetArray = getCorrectCharArrayForComparison(inputArray);

        int index = getFirstIndexOfMissingCharArr(inputArray);

        List<Character> alphabetCharsList = new ArrayList<>();
        for (int j = index; j < (inputArray.length + index); j++) {
            alphabetCharsList.add(alphabetArray[j]);
        }

        List<Character> inputCharsList = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            inputCharsList.add(inputArray[i]);
        }

        return getMissingLetter(inputCharsList, alphabetCharsList);
    }

    private char[] getCorrectCharArrayForComparison(char[] array) {
        if (Character.isUpperCase(array[0])) {
            return new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V',
                    'W','X','Y','Z'};
        }
        return new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r', 's','t','u','v','w'
                ,'x','y','z'};
    }

    private int getFirstIndexOfMissingCharArr(char[] array) {
        char[] chars = getCorrectCharArrayForComparison(array);
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (array[0] == chars[i]) {
                index = i;
            }
        }
        return index;
    }

    private char getMissingLetter(List<Character> inputList, List<Character> alphabetList) {
        char result = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (!inputList.get(i).equals(alphabetList.get(i))) {
                result = alphabetList.get(i);
                break;
            }
        }
        return result;
    }

    @Test
    public void findMissingLetterTest() {
        assertEquals('P', findMissingLetter(new char[] { 'O','Q','R','S' }));
        assertEquals('e', findMissingLetter(new char[] { 'a','b','c','d','f' }));

    }

}
