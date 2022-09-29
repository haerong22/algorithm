package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18352
 *
 * 특정 거리의 도시 찾기
 */
public class P_18352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> road = new ArrayList<>();
        int[] d = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            String[] roadInfo = br.readLine().split(" ");

            int start = Integer.parseInt(roadInfo[0]);
            int end = Integer.parseInt(roadInfo[1]);

            road.get(start).add(end);
        }

        Queue<Integer> q = new LinkedList<>();
        d[X] = 0;
        q.offer(X);

        while (!q.isEmpty()) {

            int n = q.poll();

            for (int i = 0; i < road.get(n).size(); i++) {
                int next = road.get(n).get(i);

                if (d[next] == -1) {
                    d[next] = d[n] + 1;
                    q.offer(next);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }
}