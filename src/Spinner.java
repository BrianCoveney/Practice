import java.util.*;

/**
 * Created by brian on 26/05/17.
 */
public class Spinner {


    public Spinner() {

    }

    public Spinner(String spin) {
        this.spinWords(spin);
    }


    public String spinWords(String sentence) {

        Stack<String> stackFinal = new Stack<>();
        Stack<String> stack = new Stack<>();

        if (sentence.length() >= 5) {
            String[] wordSplit = sentence.split(" ");

            for (int i = 0; i < wordSplit.length; i++) {

                if (wordSplit[i].length() < 5) {
                    stackFinal.push(wordSplit[i]);
                }
                else if (wordSplit[i].length() >= 5) {

                    stack.push(wordSplit[i]);

                    List<String> arrayList = new ArrayList<>();
                    while (stack.size() > 0) {
                        arrayList.add(stack.pop());
                    }

                    String word = reverseWords(arrayList);

                    stackFinal.push(word);
                }
            }
        }
        else {
            return sentence;
        }

        sentence = formatStack(stackFinal);

        System.out.println(sentence);
        return sentence;
    }


    public String reverseWords(List<String> list) {
        String word = null;
        Stack<String> stack = new Stack<>();
        if (list != null) {
            for (String s : list) {
                for (int j = s.length() - 1; j >= 0; j--) {
                    stack.push(String.valueOf(s.charAt(j)));
                }
                word = formatWord(stack.toString());
            }
        }
        return word;
    }


    public String formatStack(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new LinkedHashSet<>(stack);

        for (String string : set)
            sb.append(string).append(" ");

        String words = sb.toString();
        return formatWord(words).trim();
    }


    public String formatWord(String input) {
        String formatted = input
                .replace("]", "")
                .replace("[", "")
                .replace(", ", "")
                .replace("  ", " ");

        return formatted;
    }

}
