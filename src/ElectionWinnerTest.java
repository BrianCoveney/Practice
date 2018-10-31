import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ElectionWinnerTest {

    private String[] votes;

    @Before
    public void setUp() {
        votes = new String[] {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
    }

    @Test
    public void electionWinner() {
        Map<String, Integer> candidatesToVotesMap = createMap(votes);

        Map<String, Integer> sortedMap = createSortedMap(candidatesToVotesMap);

        String winner = getSecondLastEntryWithMaxVotes(sortedMap);

        assertEquals("Michael", winner);
    }

    private Map<String, Integer> createMap(String[] votes) {
        Map<String, Integer> map = new HashMap<>();
        for (String vote : votes) {
            if (map.keySet().contains(vote)) {
                int voteCount = map.get(vote);
                map.put(vote, voteCount + 1);
            } else {
                map.put(vote, 1);
            }
        }
        return map;
    }

    private Map<String, Integer> createSortedMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    private String getSecondLastEntryWithMaxVotes(Map<String, Integer> map) {
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        // Michael and Mary have the highest number of votes, but because Michael is alphabetically last we need the
        // second last index
        int secondLastIndex = set.size() -2;

        Map.Entry entry = null;
        for (int i = 0; iterator.hasNext(); i++) {
            entry = (Map.Entry) iterator.next();
            if (i == secondLastIndex) {
                break;
            }
        }
        return String.valueOf(entry.getKey());
    }

    private String mapToString(Map<String, Integer> map) {
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result += (entry.getKey() +"="+ entry.getValue()+"\n");
        }
        return result;
    }
}