package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14425
 *
 * 문자열 집합
 */
public class P_14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> set = new HashMap<>();

        for (int i = 0; i < N; i++) {
            set.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            if (set.containsKey(br.readLine())) {
                result++;
            }
        }

        System.out.println(result);
    }
}