package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1935
 *
 * 후위 표기식2
 */
public class P_1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String expression = br.readLine();

        Stack<Double> stack = new Stack<>();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                stack.push((double) nums[c - 65]);
            } else {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                double temp = 0.0;

                switch (c) {
                    case '+' : temp = operand2 + operand1; break;
                    case '-' : temp = operand2 - operand1; break;
                    case '*' : temp = operand2 * operand1; break;
                    case '/' : temp = operand2 / operand1; break;
                }

                stack.push(temp);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}