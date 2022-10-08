package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15721
 *
 * 번데기
 */
public class P_15721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        boolean type = Integer.parseInt(br.readLine()) == 1;

        int cnt = 1;
        int b = 0;
        int d = 0;

        w:while (true) {
            cnt++;

            for (int i = 0; i < 4; i++) {

                if (i % 2 == 0) {
                    b++;

                    if (!type && b == T) {
                         result = (b + d - 1) % A;
                         break w;
                    }

                } else {
                    d++;

                    if (type && d == T) {
                        result = (b + d - 1) % A;
                        break w;
                    }
                }
            }

            for (int i = 0; i < cnt; i++) {
                b++;
                if (!type && b == T) {
                    result = (b + d - 1) % A;
                    break w;
                }
            }

            for (int i = 0; i < cnt; i++) {
                d++;

                if (type && d == T) {
                    result = (b + d - 1) % A;
                    break w;
                }
            }
        }

        System.out.println(result);
    }
}