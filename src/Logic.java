
public class Logic {


    // Return the sum of two 6-sided dice rolls, each in the range 1..6.
    // However, if noDoubles is true, if the two dice show the same value,
    // increment one die to the next value, wrapping around to 1 if its value was 6
    public int withoutDoubles(int die1, int die2, boolean noDoubles) {
        if (noDoubles && die1 == die2) {
            if (die2 == 6 && die1 == 6) {
                die2 = 1;
                die1 = 6;
            } else {
                die1++;
            }
        }
        return die1 + die2;
    }


    // Given two int values, return whichever value is larger. However if the two values
    // have the same remainder when divided by 5, then the return the smaller value.
    // However, in all cases, if the two values are the same, return 0
    public int maxMod5(int a, int b) {
        int result;
        if (a > b) {
            result = a;
        } else {
            result = b;
        }

        if (a % 5 == b % 5) {
            if (a < b) {
                result = a;
            } else {
                result = b;
            }
        }

        if (a == b) {
            result = 0;
        }
        return result;
    }



    // You have a red lottery ticket showing ints a, b, and c, each of which is 0, 1, or 2.
    // If they are all the value 2, the result is 10. Otherwise if they are all the same,
    // the result is 5. Otherwise so long as both b and c are different from a, the result is 1.
    // Otherwise the result is 0.
    public int redTicket(int a, int b, int c) {
        int result = 0;
        if (a == 2 && b == 2 && c == 2) {
            result = 10;
        }
        else if (a == b && b == c) {
            result = 5;
        }
        else if (a != c && a != b) {
            result = 1;
        }
        else {
            result = 0;
        }

        return result;
    }


}
