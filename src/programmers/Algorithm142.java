package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 * 거리두기 확인하기
 */

public class Algorithm142 {
    public static void main(String[] args) {

        final String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        System.out.println(Arrays.toString(new Solution().solution(places)));
    }

    static class Solution {

        public int[] solution(String[][] places) {
            int[] answer = new int[5];

            for (int i = 0; i < 5; i++) {
                String[] p = places[i];

                int done = 1;
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (p[x].charAt(y) == 'P') {
                            if (!bfs(x, y, p)) done = 0;
                        }
                    }
                }
                answer[i] = done;
            }

            return answer;
        }

        private boolean bfs(int x, int y, String[] p) {
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});

            while (!queue.isEmpty()) {
                int[] c = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = c[0] + dx[i];
                    int ny = c[1] + dy[i];

                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || (x == nx && y == ny)) continue;

                    int d = Math.abs(x - nx) + Math.abs(y - ny);

                    if (p[nx].charAt(ny) == 'P' && d <= 2) return false;

                    if (p[nx].charAt(ny) == 'O' && d <= 1) queue.add(new int[]{nx, ny});
                }
            }

            return true;
        }
    }
}