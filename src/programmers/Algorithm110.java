package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 * [1차] 캐시
 */

public class Algorithm110 {
    public static void main(String[] args) {

        final int cacheSize = 3;
        final String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(new Solution().solution(cacheSize, cities));
    }

    static class Solution {

        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            if (cacheSize == 0) {
                return cities.length * 5;
            }

            final Queue<String> cache = new LinkedList<>();

            for (String city : cities) {
                String s = city.toUpperCase();

                if (cache.remove(s)) {
                    answer++;
                    cache.add(s);
                } else {
                    answer += 5;
                    if (cache.size() == cacheSize) {
                        cache.remove();
                    }
                    cache.add(s);
                }
            }

            return answer;
        }
    }
}