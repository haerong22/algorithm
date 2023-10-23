package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * 미로 탈출
 */

public class Algorithm144 {
    public static void main(String[] args) {

//        final String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        final String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        System.out.println(new Solution().solution(maps));
    }

    static class Solution {

        private final int[] dx = {-1, 1, 0, 0};
        private final int[] dy = {0, 0, -1, 1};
        private String[] maps;

        public int solution(String[] maps) {
            this.maps = maps;
            int[] start = findTarget('S');
            int[] lever = findTarget('L');

            int toLever = bfs(start, 'L');
            int toEnd = bfs(lever, 'E');

            return toLever == -1 || toEnd == -1 ? -1 : toLever + toEnd;
        }

        private int[] findTarget(char target) {
            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[0].length(); j++) {
                    if (maps[i].charAt(j) == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[2];
        }

        private int bfs(int[] start, char target) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start[0], start[1], 0});

            boolean[][] visited = new boolean[maps.length][maps[0].length()];
            visited[start[0]][start[1]] = true;

            while (!queue.isEmpty()) {
                int[] c = queue.poll();

                if (maps[c[0]].charAt(c[1]) == target) {
                    return c[2];
                }

                for (int i = 0; i < 4; i++) {
                    int nx = c[0] + dx[i];
                    int ny = c[1] + dy[i];

                    if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length() || visited[nx][ny]) {
                        continue;
                    }

                    if (maps[nx].charAt(ny) != 'X') {
                        queue.add(new int[]{nx, ny, c[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }

            return -1;
        }

    }
}