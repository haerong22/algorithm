package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 * 숫자 변환하기
 */

public class Algorithm125 {
    public static void main(String[] args) {

        final int x = 2;
        final int y = 5;
        final int n = 4;

        System.out.println(new Solution().solution(x, y, n));
    }

    static class Solution {

        public int solution(int x, int y, int n) {
            int[] answer = new int[y + 1];
            Arrays.fill(answer, Integer.MAX_VALUE);

            answer[x] = 0;
            for (int i = x; i <= y; i++) {
                if (answer[i] == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    continue;
                }

                if (i + n <= y) {
                    answer[i + n] = Math.min(answer[i] + 1, answer[i + n]);
                }

                if (i * 2 <= y) {
                    answer[i * 2] = Math.min(answer[i] + 1, answer[i * 2]);
                }

                if (i * 3 <= y) {
                    answer[i * 3] = Math.min(answer[i] + 1, answer[i * 3]);
                }
            }

            return answer[y];
        }
    }
}