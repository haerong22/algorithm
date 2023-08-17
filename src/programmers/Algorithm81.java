package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=java
 * 달리기 경주
 */

public class Algorithm81 {
    public static void main(String[] args) {
        final String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        final String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings) {

        final Map<String, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (String calling : callings) {
            final Integer rank = rankMap.get(calling);
            final String player = players[rank - 1];

            rankMap.put(calling, rank - 1);
            rankMap.put(player, rank);

            players[rank - 1] = calling;
            players[rank] = player;
        }

        return players;
    }
}
