package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1806
 *
 * 부분합
 */
public class P_1806 {

    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        arr = new int[N + 1];

        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(s1[i - 1]);
        }

        search();
    }

    public static void search() {
        int R = 0, sum = 0, answer = N + 1;

        for (int L = 1; L <= N; L++) {
            sum -= arr[L - 1];


            while (R + 1 <= N && sum < S) {
                sum += arr[++R];
            }

            if (sum >= S) {
                answer = Math.min(answer, R - L + 1);
            }
        }

        if (answer == N + 1) answer = 0;

        System.out.println(answer);
    }
}
