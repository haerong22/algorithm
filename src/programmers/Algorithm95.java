package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/135808
 * 과일 장수
 */

public class Algorithm95 {
    public static void main(String[] args) {
        final int k = 4;
        final int m = 3;
        final int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(new Solution().solution(k, m, score));
    }

    static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            Arrays.sort(score);
            for (int i = score.length; i > 0; i--) {
                if ((score.length - i + 1) % m == 0) {
                    answer += score[i - 1] * m;
                }
            }
            return answer;
        }
    }
}