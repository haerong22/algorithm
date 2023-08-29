package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
 * 명예의 전당 (1)
 */

public class Algorithm93 {
    public static void main(String[] args) {
        final int k = 4;
        final int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        System.out.println(Arrays.toString(new Solution().solution(k, score)));
    }

    static class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            List<Integer> scores = new ArrayList<>();

            for (int i = 0; i < score.length; i++) {
                scores.add(score[i]);
                scores.sort(Collections.reverseOrder());
                int idx = i < k ? i : k - 1;
                answer[i] = scores.get(idx);
            }

            return answer;
        }
    }

}