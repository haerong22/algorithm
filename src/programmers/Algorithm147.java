package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/169199
 * 리코쳇 로봇
 */

public class Algorithm147 {
    public static void main(String[] args) {

        final String[] board = {
                "...D..R", ".D.G...", "....D.D", "D....D.", "..D...."
        };

        System.out.println(new Solution().solution(board));
    }

    static class Solution {

        private final int[] dx = {-1, 1, 0, 0};
        private final int[] dy = {0, 0, -1, 1};

        public int solution(String[] board) {
            int[] start = findStart(board);
            return bfs(board, start);
        }

        private int[] findStart(String[] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length(); j++) {
                    if (board[i].charAt(j) == 'R') {
                        return new int[]{i, j};
                    }
                }
            }

            return new int[2];
        }

        private int bfs(String[] board, int[] start) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start[0], start[1], 0});

            boolean[][] visited = new boolean[board.length][board[0].length()];
            visited[start[0]][start[1]] = true;

            while (!queue.isEmpty()) {
                int[] c = queue.poll();

                if (board[c[0]].charAt(c[1]) == 'G') return c[2];

                for (int i = 0; i < 4; i++) {
                    int nx = c[0] + dx[i];
                    int ny = c[1] + dy[i];

                    while (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length() && board[nx].charAt(ny) != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    }

                    nx -= dx[i];
                    ny -= dy[i];

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, c[2] + 1});
                    }
                }
            }

            return -1;
        }
    }
}