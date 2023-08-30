package programmers;

import java.util.stream.IntStream;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * 기사단원의 무기
 */

public class Algorithm94 {
    public static void main(String[] args) {
        final int number = 5;
        final int limit = 3;
        final int power = 2;

        System.out.println(new Solution().solution(number, limit, power));
    }

    static class Solution {
        public int solution(int number, int limit, int power) {
            return IntStream.range(1, number + 1).map(v -> {
                        int cnt = 0;
                        for (int i = 1; i <= Math.sqrt(v); i++) {
                            if (v % i == 0) {
                                cnt++;
                                if (v / i != i) {
                                    cnt++;
                                }
                            }
                        }
                        return cnt > limit ? power : cnt;
                    })
                    .sum();
        }
    }
}