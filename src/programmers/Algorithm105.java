package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181187
 * 두 원 사이의 정수 쌍
 */

public class Algorithm105 {
    public static void main(String[] args) {

        final int r1 = 2;
        final int r2 = 3;

        System.out.println(new Solution().solution(r1, r2));
    }

    static class Solution {

        public long solution(int r1, int r2) {
            long answer = 0;

            for (int x = 1; x <= r2; x++) {
                long minH = (long) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * x * x));
                long maxH = (long) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * x * x));

                answer += (maxH - minH + 1);
            }

            return answer * 4;
        }
    }
}