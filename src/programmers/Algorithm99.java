package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132267
 * 콜라 문제
 */

public class Algorithm99 {
    public static void main(String[] args) {
        final int a = 3;
        final int b = 1;
        final int n = 20;

        System.out.println(new Solution().solution(a, b, n));
    }

    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            while (n >= a) {
                int q = n / a;
                n = n - (q * a) + (q * b);
                answer += q * b;
            }

            return answer;
        }

    }
}