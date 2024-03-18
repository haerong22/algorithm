package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/7795
 *
 * 먹을 것인가 먹힐 것인가
 */
public class P_7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);

            int[] arrA = new int[A];
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < A; j++) {
                arrA[j] = Integer.parseInt(a[j]);
            }

            int[] arrB = new int[B];
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < B; j++) {
                arrB[j] = Integer.parseInt(b[j]);
            }

            Arrays.sort(arrB);

            int answer = 0;
            for (int target : arrA) {
                int left = 0;
                int right = arrB.length - 1;

                int result = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (arrB[mid] < target) {
                        result = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                answer += result + 1;
            }
            System.out.println(answer);
        }
    }

}