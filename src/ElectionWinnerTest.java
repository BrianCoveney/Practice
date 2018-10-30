import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ElectionWinnerTest {

    private String[] votes;

    @Before
    public void setUp() {
        votes = new String[] {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
    }

    @Test
    public void electionWinner() {
        Map<String, Integer> map = createMapOfCandidatesVotes(votes);

        List<Map.Entry<String, Integer>> list = createSortedList(map);

        String winner = getWinner(list);

        assertEquals("Michael", winner);
    }

    private Map<String, Integer> createMapOfCandidatesVotes(String[] votes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length ; i++) {
            if (map.containsKey(votes[i])) {
                int num = map.get(votes[i]);
                map.put(votes[i], num + 1);
            }
            else {
                map.put(votes[i], 1);
            }
        }
        return map;
    }

    private List<Map.Entry<String, Integer>> createSortedList(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list;
    }

    private String getWinner(List<Map.Entry<String, Integer>> list) {
        int lastIndex = list.size() - 1;

        // Michael and Mary have the highest number of votes, but because Michael is alphabetically last we need the
        // second last index
        int secondLastIndex = lastIndex -1;

        String winner = list.get(secondLastIndex).getKey();
        return winner;
    }
}