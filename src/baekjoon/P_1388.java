package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1388 {

    static int N, M;
    static char[][] deco;
    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        deco = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                deco[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) continue;

                dfs(i, j, deco[i][j] == '-');

                result++;
            }
        }


        System.out.println(result);
    }

    private static void dfs(int i, int j, boolean isRow) {
        visited[i][j] = true;

        if (isRow) {
            if (++j < M && deco[i][j] == '-') {
                dfs(i, j, true);
            }
        } else {
            if (++i < N && deco[i][j] == '|') {
                dfs(i, j, false);
            }
        }
    }
}