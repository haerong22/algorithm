package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2178
 * <p>
 * 미로 탐색
 */
public class P_2178 {

    static int N, M;
    static String[] maze;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        maze = new String[N];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine();
        }

        bfs(0, 0);
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        dist[x][y] = 1;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (maze[nx].charAt(ny) == '0' || visited[nx][ny]) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }
    }
}