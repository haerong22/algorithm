package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 * 빛의 경로 사이클
 */

public class Algorithm164 {
    public static void main(String[] args) {

//        final String[] grid = {"SL", "LR"};
        final String[] grid = {"S"};

        System.out.println(Arrays.toString(new Solution().solution(grid)));
    }

    static class Solution {

        private final int[] dr = {-1, 0, 1, 0};
        private final int[] dc = {0, -1, 0, 1};
        private int R, C;
        private final List<Integer> answer = new ArrayList<>();

        public int[] solution(String[] grid) {
            R = grid.length;
            C = grid[0].length();

            boolean[][][] visited = new boolean[R][C][4];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    for (int k = 0; k < 4; k++) {
                        cycle(grid, visited, i, j, k);
                    }
                }
            }

            return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
        }

        private void cycle(String[] grid, boolean[][][] visited, int r, int c, int d) {
            int cnt = 0;

            while (!visited[r][c][d]) {

                cnt++;
                visited[r][c][d] = true;

                char direction = grid[r].charAt(c);

                if (direction == 'L') {
                    d = (d + 3) % 4;
                } else if (direction == 'R') {
                    d = (d + 1) % 4;
                }

                r = (r + dr[d] + R) % R;
                c = (c + dc[d] + C) % C;
            }

            if (cnt != 0) {
                answer.add(cnt);
            }
        }

    }
}