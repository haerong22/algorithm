package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/9663
 *
 * N-Queen
 */
public class P_9663 {

    static int N, answer = 0;
    static int[] queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen = new int[N + 1];

        calculate(1);
        System.out.println(answer);
    }

    public static void calculate(int row) {
        if (row == N + 1) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                boolean possible = true;
                for (int j = 1; j <= row - 1; j++) {
                    if (attackable(row, i, j, queen[j])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    queen[row] = i;
                    calculate(row + 1);
                    queen[row] = 0;
                }
            }
        }
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }
}