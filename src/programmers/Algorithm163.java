package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/169198
 * 당구 연습
 */

public class Algorithm163 {
    public static void main(String[] args) {

        final int m = 10;
        final int n = 10;
        final int startX = 3;
        final int startY = 7;
        final int[][] balls = {{7, 7}, {2, 7}, {7, 3}};

        System.out.println(Arrays.toString(new Solution().solution(m, n, startX, startY, balls)));
    }

    static class Solution {

        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];

            for (int i = 0; i < balls.length; i++) {
                int min = Integer.MAX_VALUE;
                int[] ball = balls[i];

                if (startX != ball[0] || ball[1] <= startY) {
                    min = Math.min(min, dist(startX, startY, ball[0], n + n - ball[1]));
                }

                if (startX != ball[0] || ball[1] >= startY) {
                    min = Math.min(min, dist(startX, startY, ball[0], -1 * ball[1]));
                }

                if (startY != ball[1] || ball[0] >= startX) {
                    min = Math.min(min, dist(startX, startY, -1 * ball[0], ball[1]));
                }

                if (startY != ball[1] || ball[0] <= startX) {
                    min = Math.min(min, dist(startX, startY, m + m - ball[0], ball[1]));
                }

                answer[i] = min;
            }

            return answer;
        }

        private int dist(int startX, int startY, int x, int y) {
            return (int) (Math.pow(startX - x, 2) + Math.pow(startY - y, 2));
        }

    }
}