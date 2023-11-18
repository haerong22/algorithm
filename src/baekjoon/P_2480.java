package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2480
 *
 * 주사위 세개
 */
public class P_2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int reward;
        if (a == b && a == c) {
            reward = 10000 + a * 1000;
        } else if (a != b && a != c && b != c) {
            int n = Math.max(Math.max(a, b), c);
            reward = n * 100;
        } else {
            int n = a == b || a == c ? a : b;
            reward = 1000 + n * 100;
        }

        System.out.println(reward);
    }
}