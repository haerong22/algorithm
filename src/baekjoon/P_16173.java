package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_16173 {

    private static int[][] board;
    private static boolean[][] visited;
    private static int N;
    private static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        dfs(0, 0);

        System.out.println(result ? "HaruHaru" : "Hing");
    }

    public static void dfs(int x, int y) {

        if (x >= N || y >= N || visited[x][y]) {
            return;
        }

        int cur = board[x][y];

        if (cur == -1) {
            result = true;
            return;
        }

        visited[x][y] = true;

        dfs(x + cur, y);
        dfs(x, y + cur);

    }
}