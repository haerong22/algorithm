package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * 할인 행사
 */

public class Algorithm112 {
    public static void main(String[] args) {

        final String[] want = {"banana", "apple", "rice", "pork", "pot"};
        final int[] number = {3, 2, 2, 2, 1};
        final String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(new Solution().solution(want, number, discount));
    }

    static class Solution {

        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            for (int i = 0; i < discount.length - 9; i++) {
                Map<String, Integer> map = new HashMap<>();
                for (int j = 0; j < 10; j++) {
                    map.put(discount[i + j], map.getOrDefault(discount[i + j], 0) + 1);
                }

                boolean a = true;
                for (int j = 0; j < want.length; j++) {
                    if (number[j] > map.getOrDefault(want[j], 0)) {
                        a = false;
                        break;
                    }
                }
                if (a) {
                    answer++;
                }
            }
            
            return answer;
        }
    }
}