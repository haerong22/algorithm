package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1015
 *
 * 수열 정렬
 */
public class P_1015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        B[] B = new B[N];
        int[] P = new int[N];

        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            B[i] = new B(Integer.parseInt(arr[i]), i);
        }

        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : P) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static class B implements Comparable<B> {

        int num, idx;

        public B(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(B o) {
            return num - o.num;
        }
    }
}