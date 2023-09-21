package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * k진수에서 소수 개수 구하기
 */

public class Algorithm114 {
    public static void main(String[] args) {

        final int n = 437674;
        final int k = 3;
        System.out.println(new Solution().solution(n, k));
    }

    static class Solution {

        public int solution(int n, int k) {
            int answer = 0;

            String convert = Integer.toString(n, k);

            for (String s : convert.split("0")) {
                long num = !s.equals("") ? Long.parseLong(s) : 0;
                if (isPrime(num)) {
                    answer ++;
                }
            }

            return answer;
        }

        private boolean isPrime(long num) {
            if (num <= 1) {
                return false;
            }

            for (long i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;

            }

            return true;
        }
    }
}