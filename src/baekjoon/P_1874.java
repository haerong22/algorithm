package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 *
 * 스택 수열
 */
public class P_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int offset = 1;

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(br.readLine());

            while (offset <= next) {
                stack.push(offset++);
                result.append("+").append("\n");
            }

            if (stack.pop() == next) {
                result.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(result);
    }
}