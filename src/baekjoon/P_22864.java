package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22864
 *
 * 피로도
 */
public class P_22864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int fatigue = 0;

        for (int i = 0; i < 24; i++) {
            if (fatigue + A <=  M) {
                result += B;
                fatigue += A;
            } else {
                fatigue = Math.max(fatigue - C, 0);
            }
        }

        System.out.println(result);
    }
}