package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 * 교점에 별 만들기
 */

public class Algorithm159 {
    public static void main(String[] args) {

        final int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        System.out.println(Arrays.toString(new Solution().solution(line)));
    }

    static class Solution {

        private final List<int[]> ip = new ArrayList<>();
        private final int[] start = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        private final int[] end = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};

        public String[] solution(int[][] line) {

            findPoint(line);

            int w = end[0] - start[0] + 1;
            int h = start[1] - end[1] + 1;

            String[] answer = new String[h];

            for (int i = 0; i < h; i++) {
                answer[i] = ".".repeat(w);
            }

            for (int[] i : ip) {
                int x = i[0] - start[0];
                int y = start[1] - i[1];

                answer[y] = answer[y].substring(0, x) + "*" + answer[y].substring(x + 1);
            }

            return answer;
        }

        private void findPoint(int[][] line) {
            for (int i = 0; i < line.length - 1; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    int[] a = line[i];
                    int[] b = line[j];

                    int denominator = a[0] * b[1] - a[1] * b[0];
                    if (denominator == 0) continue;
                    long x = (long) a[1] * (long) b[2] - (long) a[2] * (long) b[1];
                    long y = (long) a[2] * (long) b[0] - (long) a[0] * (long) b[2];

                    if (x % denominator == 0 && y % denominator == 0) {
                        x = x / denominator;
                        y = y / denominator;
                        ip.add(new int[]{(int) x, (int) y});
                    }
                }
            }

            for (int[] i : ip) {
                start[0] = Math.min(start[0], i[0]);
                start[1] = Math.max(start[1], i[1]);
                end[0] = Math.max(end[0], i[0]);
                end[1] = Math.min(end[1], i[1]);
            }
        }

    }
}