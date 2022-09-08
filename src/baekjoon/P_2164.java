package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * https://www.acmicpc.net/problem/2164
 *
 * 카드2
 */
public class P_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result;
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            deque.add(i);
        }

        while (deque.size() > 2) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }

        result = deque.pollLast();

        System.out.println(result);
    }
}