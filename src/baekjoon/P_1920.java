package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1920
 * <p>
 * 수 찾기
 */
public class P_1920 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        String[] target = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(target[i]);

            if (binarySearch(0, N - 1, x)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(int l, int r, int x) {

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == x) return true;

            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}