package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 * 요격 시스템
 */

public class Algorithm104 {
    public static void main(String[] args) {
        final int[][] targets = {
                {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}
        };

        System.out.println(new Solution().solution(targets));
    }

    static class Solution {

        public int solution(int[][] targets) {
            int answer = 1;

            Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

            int shoot = targets[0][1] - 1;

            for (int[] target : targets) {
                if (target[0] <= shoot && target[1] >= shoot) continue;

                shoot = target[1] - 1;
                answer++;
            }

            return answer;
        }
    }
}