package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Predicate;

/**
 * https://www.acmicpc.net/problem/18312
 *
 * 시각
 */
public class P_18312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Predicate<Integer> cond = (x) -> x % 10 == K || x / 10 == K;

        for (int i = 0; i <= N; i++) {
            if (cond.test(i)) {
                result += 3600;
            } else {
                for (int j = 0; j < 60; j++) {
                    if (cond.test(j)) {
                        result += 60;
                    } else {
                        for (int k = 0; k < 60; k++) {
                            if (cond.test(k)) {
                                result += 1;
                            }
                        }
                    }
                }
            }

        }

        System.out.println(result);
    }
}