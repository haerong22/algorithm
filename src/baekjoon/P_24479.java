package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/24479
 *
 * 알고리즘 수업 - 깊이 우선 탐색 1
 */
public class P_24479 {

    static int N, M, R, cnt;
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        node = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        cnt = 1;

        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            node[from].add(to);
            node[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(node[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        answer[start] = cnt++;

        for (int n : node[start]) {

            if (visited[n]) continue;

            visited[n] = true;
            dfs(n);
        }
    }
}