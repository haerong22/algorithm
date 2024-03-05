package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1005
 * <p>
 * ACM Craft
 */
public class P_1005 {

    static int T, N, K;

    static ArrayList<Integer>[] order;
    static int[] time, indeg, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input(br);

            Queue<Integer> q = new LinkedList<>();
            for (int j = 1; j <= N; j++) {
                if (indeg[j] == 0) {
                    q.add(j);
                    answer[j] = time[j];
                }
            }

            while (!q.isEmpty()) {
                int p = q.poll();

                for (int to : order[p]) {
                    indeg[to]--;
                    if (indeg[to] == 0) q.add(to);
                    answer[to] = Math.max(answer[to], answer[p] + time[to]);
                }
            }

            int W = Integer.parseInt(br.readLine());
            System.out.println(answer[W]);
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[N + 1];
        order = new ArrayList[N + 1];
        indeg = new int[N + 1];
        answer = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            order[j] = new ArrayList<>();
            time[j] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            order[from].add(to);
            indeg[to]++;
        }
    }
}