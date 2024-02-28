package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2805
 *
 * 나무 자르기
 */
public class P_2805 {

    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        tree = new int[N];

        String[] t = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(t[i]);
        }

        int answer = search();
        System.out.println(answer);
    }

    private static int search() {
        int L = 1, R = 1000000000;

        int result = 0;
        while (L <= R) {
            int mid = (L + R) / 2;

            if (isPossible(mid)) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }

        }
        return result;
    }

    private static boolean isPossible(int h) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (tree[i] > h) {
                sum += tree[i] - h;
            }
        }

        return sum >= M;
    }
}