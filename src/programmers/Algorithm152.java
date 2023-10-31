package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 * N-Queen
 */

public class Algorithm152 {
    public static void main(String[] args) {

        final int n = 4;

        System.out.println(new Solution().solution(n));
    }

    static class Solution {

        private int[] queen;
        private int answer;
        private int n;

        public int solution(int n) {
            this.answer = 0;
            this.n = n;
            this.queen = new int[n];

            queen(0);

            return answer;
        }

        private void queen(int row) {
            if (row == n) {
                answer++;
                return;
            }

            for (int i = 0; i < n; i++) {
                queen[row] = i;

                if (check(row)) {
                    queen(row + 1);
                }
            }
        }

        private boolean check(int row) {
            for (int i = 0; i < row; i++) {
                if (queen[i] == queen[row]) return false;
                if (Math.abs(i - row) == Math.abs(queen[i] - queen[row])) return false;
            }

            return true;
        }

    }
}