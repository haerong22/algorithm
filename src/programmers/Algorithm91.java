package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 * 가장 가까운 같은 글자
 */

public class Algorithm91 {
    public static void main(String[] args) {
        final String s = "banana";

        System.out.println(Arrays.toString(new Solution().solution(s)));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];

            Map<Character, Integer> indexes = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer idx = indexes.get(c);
                answer[i] = idx == null ? -1 : i - idx;
                indexes.put(c, i);
            }

            return answer;
        }
    }

}