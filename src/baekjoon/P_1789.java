package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1789
 * <p>
 * 수들의 합
 */
public class P_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        int cnt = 1;
        long sum = 0L;
        while (true) {
            sum += cnt;

            if (sum > S) break;
            cnt++;
        }
        System.out.println(cnt - 1);
    }
}