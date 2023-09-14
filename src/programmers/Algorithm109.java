package programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 * 귤 고르기
 */

public class Algorithm109 {
    public static void main(String[] args) {

        final int k = 6;
        final int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(new Solution().solution(k, tangerine));
    }

    static class Solution {

        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> size = new HashMap<>();

            for (int i : tangerine) {
                size.put(i, size.getOrDefault(i, 0) + 1);
            }

            int[] cnt = size.values().stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

            for (int i : cnt) {
                if (k <= 0) break;
                answer++;
                k -= i;
            }

            return answer;
        }
    }
}