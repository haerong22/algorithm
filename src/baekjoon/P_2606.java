package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2606
 *
 * 바이러스
 */
public class P_2606 {

    public static List<List<Integer>> networks = new ArrayList<>();
    public static boolean[] visited;
    public static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        int V = Integer.parseInt(br.readLine());

        visited = new boolean[C+1];

        for (int i = 0; i <= C; i++) {
            networks.add(new ArrayList<>());
        }

        StringTokenizer st;

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            networks.get(start).add(end);
            networks.get(end).add(start);
        }

        dfs(1);

        System.out.println(result - 1);
    }

    private static void dfs(int n) {

        if (visited[n]) {
            return;
        }

        visited[n] = true;
        result++;

        for (Integer i : networks.get(n)) {
            dfs(i);
        }
    }
}