package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1068
 *
 * 트리
 */
public class P_1068 {

    static int N, root, remove;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        leaf = new int[N];
        child = new ArrayList[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                root = i;
                continue;
            }

            child[p].add(i);
        }

        remove = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (child[i].contains(remove)) {
                child[i].remove((Integer) remove);
            }
        }

        if (root != remove) {
            dfs(root, -1);
        }

        System.out.println(leaf[root]);
    }

    public static void dfs(int x, int p) {
        if (child[x].isEmpty()) leaf[x]++;

        for (int c : child[x]) {
            if (c == p) continue;

            dfs(c, x);
            leaf[x] += leaf[c];
        }
    }
}