package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/14502
 *
 * 연구소
 */
public class P_14502 {

    static int N, M, B, answer;
    static int[][] lab, wall;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        lab = new int[N][M];
        visited = new boolean[N][M];
        wall = new int[N * M][2];

        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(s1[j]);
            }
        }

        // 빈 공간 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    wall[B][0] = i;
                    wall[B][1] = j;
                    B++;
                }
            }
        }

        // 벽 3개 설치
        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int idx, int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        if (idx >= B) return;

        lab[wall[idx][0]][wall[idx][1]] = 1;
        dfs(idx + 1, cnt + 1);
        lab[wall[idx][0]][wall[idx][1]] = 0;
        dfs(idx + 1, cnt);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                if (lab[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] c = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (lab[nx][ny] != 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0 && !visited[i][j]) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }
}