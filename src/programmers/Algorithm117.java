package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 * [3차] n진수 게임
 */

public class Algorithm117 {
    public static void main(String[] args) {

        final int n = 2;
        final int t = 4;
        final int m = 2;
        final int p = 1;
        System.out.println(new Solution().solution(n, t, m, p));
    }

    static class Solution {

        public String solution(int n, int t, int m, int p) {
            StringBuilder numbers = new StringBuilder();
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < t * m; i++) {
                numbers.append(Integer.toString(i, n));
            }

            for (int i = 0; i < numbers.length(); i++) {
                if ((i + 1) % m == p) {
                    answer.append(numbers.charAt(i));
                }

                if (answer.length() == t) break;
            }

            return answer.toString().toUpperCase();
        }
    }
}