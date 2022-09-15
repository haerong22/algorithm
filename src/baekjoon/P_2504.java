package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2504
 *
 * 괄호의 값
 */
public class P_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        char[] chars = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int add = 1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c == '[') {
                stack.push(c);
                add *= c == '(' ? 2 : 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (chars[i-1] == '(') {
                    result += add;
                }
                stack.pop();
                add /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (chars[i-1] == '[') {
                    result += add;
                }
                stack.pop();
                add /= 3;
            }
        }

        if (!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}