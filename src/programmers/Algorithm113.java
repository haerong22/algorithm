package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * n^2 배열 자르기
 */

public class Algorithm113 {
    public static void main(String[] args) {

        final int n = 3;
        final int left = 2;
        final int right = 5;
        System.out.println(Arrays.toString(new Solution().solution(n, left, right)));
    }

    static class Solution {

        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int) (right - left + 1)];

            int idx = 0;

            for (long i = left; i <= right; i++) {
                long x = i / n;
                long y = i % n;
                answer[idx++] = (int) (Math.max(x, y) + 1);
            }

            return answer;
        }
    }
}