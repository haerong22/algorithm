package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2525
 *
 * 오븐 시계
 */
public class P_2525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(br.readLine());

        int h = (a + (b + c) / 60) % 24;
        int m = (b + c) % 60;

        System.out.println(h + " " + m);
    }
}