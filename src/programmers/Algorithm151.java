package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/134239
 * 우박수열 정적분
 */

public class Algorithm151 {
    public static void main(String[] args) {

        final int k = 5;
        final int[][] ranges = {
                {0, 0}, {0, -1}, {2, -3}, {3, -3}
        };

        System.out.println(Arrays.toString(new Solution().solution(k, ranges)));
    }

    static class Solution {

        public double[] solution(int k, int[][] ranges) {
            double[] answer = new double[ranges.length];

            List<Integer> collatz = new ArrayList<>();

            while (k > 1) {
                collatz.add(k);
                if (k % 2 == 0) {
                    k /= 2;
                } else {
                    k = k * 3 + 1;
                }
            }
            collatz.add(k);

            double[] areas = new double[collatz.size() - 1];
            for (int i = 0; i < collatz.size() - 1; i++) {
                areas[i] = (collatz.get(i) + collatz.get(i + 1)) / 2.0;
            }

            for (int i = 0; i < ranges.length; i++) {
                int start = ranges[i][0];
                int end = areas.length + ranges[i][1];

                if (start > end) {
                    answer[i] = -1;
                } else {
                    double sum = 0;
                    for (int j = start; j < end; j++) {
                        sum += areas[j];
                    }
                    answer[i] = sum;
                }
            }

            return answer;
        }
    }
}