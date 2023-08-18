package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 * 추억 점수
 */

public class Algorithm82 {
    public static void main(String[] args) {
        final String[] name = {"may", "kein", "kain", "radi"};
        final int[] yearning = {5, 10, 1, 3};
        final String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };

        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        final Map<String, Integer> yearningMap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            for (String p : photo[i]) {
                answer[i] = answer[i] + Optional.ofNullable(yearningMap.get(p)).orElse(0);;
            }
        }

        return answer;
    }
}
