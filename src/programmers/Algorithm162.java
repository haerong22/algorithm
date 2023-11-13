package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148652
 * 유사 칸토어 비트열
 */

public class Algorithm162 {
    public static void main(String[] args) {

        final int n = 2;
        final long l = 4;
        final long r = 17;

        System.out.println(new Solution().solution(n, l, r));
    }

    static class Solution {

        public int solution(int n, long l, long r) {
            int answer = 0;

            for (l--; l < r; l++) {
                if (check(l)) answer++;
            }

            return answer;
        }

        boolean check(long l) {
            if (l < 5 && l != 2) return true;
            if ((l - 2) % 5 == 0) return false;

            return check(l / 5);
        }

    }
}