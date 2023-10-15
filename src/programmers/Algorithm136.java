package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 * 행렬 테두리 회전하기
 */

public class Algorithm136 {
    public static void main(String[] args) {

        final int rows = 6;
        final int columns = 6;
        final int[][] queries = {
                {2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}
        };
        System.out.println(Arrays.toString(new Solution().solution(rows, columns, queries)));
    }

    static class Solution {

        private final int[] dx = {1, 0, -1, 0};
        private final int[] dy = {0, 1, 0, -1};

        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            int[][] matrix = new int[rows][columns];

            for (int i = 0; i < rows * columns; i++) {
                matrix[i / columns][i % columns] = i + 1;
            }

            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int x1 = query[0] - 1;
                int y1 = query[1] - 1;
                int x2 = query[2] - 1;
                int y2 = query[3] - 1;

                int idx = 0;
                int min = Integer.MAX_VALUE;

                int cx = x1;
                int cy = y1;

                int temp = matrix[cx][cy];

                while (idx < 4) {
                    int nx = cx + dx[idx];
                    int ny = cy + dy[idx];

                    if (nx > x2 || ny > y2 || nx < x1 || ny < y1) {
                        idx++;
                    } else {
                        min = Math.min(min, matrix[cx][cy]);
                        matrix[cx][cy] = matrix[nx][ny];
                        cx = nx;
                        cy = ny;
                    }
                }

                matrix[cx][cy + 1] = temp;
                min = Math.min(min, temp);
                answer[i] = min;
            }

            return answer;
        }
    }
}