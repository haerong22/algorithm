package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 * 멀리 뛰기
 */

public class Algorithm108 {
    public static void main(String[] args) {

        final int n = 4;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {

        public long solution(int n) {
            long[] answer = new long[n + 2];
            answer[0] = 0;
            answer[1] = 1;
            answer[2] = 2;

            for (int i = 3; i < n + 1; i++) {
                answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
            }

            return answer[n];
        }
    }
}