package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 시소 짝꿍
 */

public class Algorithm141 {
    public static void main(String[] args) {

        final int[] weights = {100, 180, 360, 100, 270};
        System.out.println(new Solution().solution(weights));
    }

    static class Solution {

        public long solution(int[] weights) {
            long answer = 0;

            Map<Double, Integer> map = new HashMap<>();

            for (int w : weights) {
                map.put(w * 1.0, map.getOrDefault(w * 1.0, 0) + 1);
            }

            for (Double k : map.keySet()) {
                Integer a = map.get(k);
                answer += (long) (a) * (a - 1) / 2;

                double b = (k * 2.0) / 3.0;
                double c = (k * 1.0) / 2.0;
                double d = (k * 3.0) / 4.0;

                answer += (long) a * map.getOrDefault(b, 0);
                answer += (long) a * map.getOrDefault(c, 0);
                answer += (long) a * map.getOrDefault(d, 0);
            }

            return answer;
        }
    }
}