package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/2667
 * <p>
 * 단지번호붙이기
 */
public class P_2667 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[] house;
    static int N;
    static int cnt;
    static boolean[][] visited;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        result = new ArrayList<>();
        house = new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            house[i] = s;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && house[i].charAt(j) == '1') {
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);

        StringBuilder answer = new StringBuilder();
        answer.append(result.size()).append("\n");
        for (Integer i : result) {
            answer.append(i).append("\n");
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (house[nx].charAt(ny) == '0' || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            cnt++;
            dfs(nx, ny);
        }
    }
}