package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * 하노이의 탑
 */

public class Algorithm146 {
    public static void main(String[] args) {

        final int n = 3;

        System.out.println(Arrays.deepToString(new Solution().solution(n)));
    }

    static class Solution {
        private int[][] answer;
        private int index = 0;

        public int[][] solution(int n) {
            answer = new int[(int) (Math.pow(2, n) - 1)][2];

            hanoi(1, 3, 2, n);

            return answer;
        }

        private void hanoi(int start, int end, int mid, int n) {
            int[] move = {start, end};

            if (n == 1) {
                answer[index++] = move;
                return;
            }

            hanoi(start, mid, end, n - 1);
            answer[index++] = move;
            hanoi(mid, end, start, n - 1);
        }

    }
}