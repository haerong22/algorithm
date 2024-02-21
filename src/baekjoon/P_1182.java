package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1182
 *
 * 부분수열의 합
 */
public class P_1182 {

    static int N, S, answer = 0;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        S = Integer.parseInt(arr[1]);
        seq = new int[N];

        String[] arr1 = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(arr1[i]);
        }

        calculate(0, 0);
        System.out.println(S == 0 ? answer - 1 : answer);
    }

    public static void calculate(int k, int value) {
        if (k == N) {
            if (value == S) answer++;
        } else {
            calculate(k + 1, value);
            calculate(k + 1, value + seq[k]);
        }
    }
}