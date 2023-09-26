package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 게임 맵 최단거리
 */

public class Algorithm119 {
    public static void main(String[] args) {

        final int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        System.out.println(new Solution().solution(maps));
    }

    static class Solution {

        private final int[] dx = {1, 0, -1, 0};
        private final int[] dy = {0, 1, 0, -1};

        public int solution(int[][] maps) {
            int[][] visited = new int[maps.length][maps[0].length];

            bfs(maps, visited);

            int goal = visited[maps.length - 1][maps[0].length - 1];
            return goal == 0 ? -1 : goal;
        }

        private void bfs(int[][] maps, int[][] visited) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            visited[0][0] = 1;

            while (!queue.isEmpty()) {
                int[] current = queue.remove();
                int cx = current[0];
                int cy = current[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                        continue;
                    }

                    if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                        visited[nx][ny] = visited[cx][cy] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }

            }
        }
    }
}