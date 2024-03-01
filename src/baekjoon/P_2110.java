package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2110
 *
 * 공유기 설치
 */
public class P_2110 {

    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        int answer = search();
        System.out.println(answer);
    }

    public static int search() {
        Arrays.sort(house);

        int L = 0, R = 1000000000, ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (isPossible(mid)) {
                L = mid + 1;
                ans = mid;
            } else {
                R = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int D) {

        int cnt = 1, last = house[0];

        for (int i = 1; i < N; i++) {

            if (house[i] - last < D) continue;
            cnt++;
            last = house[i];
        }

        return cnt >= C;
    }
}