package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 *
 * 괄호
 */
public class P_9012 {

    private static final char OPEN = '(';
    private static final String Y = "YES";
    private static final String N = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            String s = br.readLine();

            result.append(solve(s)).append("\n");
        }

        System.out.println(result);
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (c == OPEN) {
                stack.add(c);
            } else if (stack.empty()){
                return N;
            } else {
                stack.pop();
            }
        }

        return stack.empty() ? Y : N;
    }
}