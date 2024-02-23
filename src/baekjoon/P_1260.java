package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1260
 *
 * DFS와 BFS
 */
public class P_1260 {

    static boolean[][] matrix;
    static int N, M, V;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        V = Integer.parseInt(s[2]);
        matrix = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            matrix[start][end] = true;
            matrix[end][start] = true;
        }

        visited = new boolean[N + 1];
        dfs(V);
        answer.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(answer.toString());
    }

    static void dfs(int start) {
        visited[start] = true;
        answer.append(start).append(" ");
        for (int i = 1; i <= N; i++) {
            if (!matrix[start][i] || visited[i]) continue;
            dfs(i);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            answer.append(poll).append(" ");

            for (int i = 1; i <= N; i++) {
                if (!matrix[poll][i] || visited[i]) continue;
                queue.add(i);
                visited[i] = true;
            }
        }
    }

}