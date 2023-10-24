package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354
 * 테이블 해시 함수
 */

public class Algorithm145 {
    public static void main(String[] args) {

        final int[][] data = {
                {2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}
        };
        final int col = 2;
        final int row_begin = 2;
        final int row_end = 3;

        System.out.println(new Solution().solution(data, col, row_begin, row_end));
    }

    static class Solution {

        private int[][] data;

        public int solution(int[][] data, int col, int row_begin, int row_end) {
            Arrays.sort(data, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);
            this.data = data;

            int answer = 0;

            for (int i = row_begin; i <= row_end; i++) {
                answer = (answer ^ s_i(i));
            }
            return answer;
        }

        private int s_i(int index) {
            return Arrays.stream(data[index - 1])
                    .map(v -> v % index)
                    .sum();
        }

    }
}