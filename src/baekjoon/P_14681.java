package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/14681
 *
 * 사분면 고르기
 */
public class P_14681 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int quadrant;

        if (x > 0) {
            quadrant = y > 0 ? 1 : 4;
        } else {
            quadrant = y > 0 ? 2 : 3;
        }

        System.out.println(quadrant);
    }
}