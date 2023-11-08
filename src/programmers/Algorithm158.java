
package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12902
 * 3 x n 타일링
 */

public class Algorithm158 {
    public static void main(String[] args) {

        final int n = 4;

        System.out.println(new Solution().solution(n));
    }

    static class Solution {

        public int solution(int n) {
            int div = 1000000007;

            int[] answer = new int[n + 1];
            answer[1] = 2;
            answer[2] = 3;

            for (int i = 3; i <= n; i++) {
                answer[i] = i % 2 == 0
                        ? (answer[i - 1] % div + answer[i - 2] % div) % div
                        : (answer[i - 1] * 2 % div + answer[i - 2] % div) % div;
            }

            return answer[n];
        }

    }
}