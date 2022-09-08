package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1158
 *
 * 요세푸스 문제
 */
public class P_1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            deque.add(i);
        }

        int cnt = 1;

        result.append("<");

        while (!deque.isEmpty()) {
            if (cnt != K) {
                deque.add(deque.pollFirst());
                cnt++;
            } else {
                result.append(deque.pollFirst());
                cnt = 1;

                if (!deque.isEmpty()) {
                    result.append(", ");
                }
            }
        }

        result.append(">");

        System.out.println(result);
    }
}