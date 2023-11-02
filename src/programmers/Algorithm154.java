package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12923
 * 숫자 블록
 */

public class Algorithm154 {
    public static void main(String[] args) {

        final long begin = 1;
        final long end = 10;

        System.out.println(Arrays.toString(new Solution().solution(begin, end)));
    }

    static class Solution {

        public int[] solution(long begin, long end) {
            int[] answer = new int[(int) (end - begin + 1)];

            int idx = 0;
            for (int i = (int) begin; i <= end; i++) {
                answer[idx++] = block(i);
            }

            return answer;
        }

        private int block(int num) {
            if (num == 1) return 0;

            int divisor = 1;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    divisor = i;
                    if (num / i <= 10000000) {
                        return num / i;
                    }
                }
            }

            return divisor;
        }

    }
}