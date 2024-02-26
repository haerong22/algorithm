package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1697
 * <p>
 * 숨바꼭질
 */
public class P_1697 {

    static int[] X, dist;
    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        X = new int[100001];
        dist = new int[100001];
        visited = new boolean[100001];

        bfs(N);

        System.out.println(dist[K]);
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        dist[x] = 0;

        while (!queue.isEmpty()) {
            int cx = queue.poll();

            int[] nxs = new int[]{cx + 1, cx - 1, 2 * cx};
            for (int nx : nxs) {
                if (nx < 0 || nx > 100000 || visited[nx]) continue;
                queue.add(nx);
                visited[nx] = true;
                dist[nx] = dist[cx] + 1;
            }
        }

    }
}