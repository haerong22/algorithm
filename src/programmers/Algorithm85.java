package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 * 덧칠하기
 */

public class Algorithm85 {
    public static void main(String[] args) {
        final int n = 8;
        final int m = 4;
        final int[] section = {2, 3, 6};

        System.out.println(new Solution().solution(n, m, section));
    }

    static class Solution {

        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int current = 0;

            for (int s : section) {
                if (current < n && s > current) {
                    answer++;
                    current = s + m - 1;
                }
            }

            return answer;
        }
    }
}