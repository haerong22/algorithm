package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15649
 *
 * N과 M (1)
 */
public class P_15649 {

    private static int N;
    private static int M;
    private static int[] selected;
    private static boolean[] used;

    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        selected = new int[M + 1];
        used = new boolean[N + 1];

        search(1);
        System.out.println(answer.toString());
    }

    public static void search(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                answer.append(selected[i]).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;

            selected[k] = i;
            used[i] = true;

            search(k + 1);

            selected[k] = 0;
            used[i] = false;
        }
    }
}