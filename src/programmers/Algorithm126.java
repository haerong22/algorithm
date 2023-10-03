package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12900
 * 2 x n 타일링
 */

public class Algorithm126 {
    public static void main(String[] args) {

        final int n = 4;

        System.out.println(new Solution().solution(n));
    }

    static class Solution {

        public int solution(int n) {
            int[] answer = new int[n + 1];

            answer[1] = 1;
            answer[2] = 2;

            for (int i = 3; i <= n; i++) {
                answer[i] = (answer[i - 1] + answer[i - 2]) % 1000000007;
            }

            return answer[n];
        }
    }
}