package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11725
 *
 * 트리의 부모 찾기
 */
public class P_11725 {

    static ArrayList<Integer>[] list;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        parents = new int[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        search(1, -1);

        for (int i = 2; i < parents.length; i++) {
            result.append(parents[i]).append("\n");
        }

        System.out.println(result);
    }

    static void search(int n, int parent) {
        for (int i : list[n]) {
            if (i == parent) continue;

            parents[i] = n;
            search(i, n);
        }
    }
}