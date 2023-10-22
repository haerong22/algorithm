package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 * 점 찍기
 */

public class Algorithm143 {
    public static void main(String[] args) {

        final int k = 2;
        final int d = 4;
        System.out.println(new Solution().solution(k, d));
    }

    static class Solution {

        public long solution(int k, int d) {
            long answer = 0;

            for (int x = 0; x <= d; x += k) {
                long y = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
                answer += y / k + 1;
            }

            return answer;
        }
    }
}