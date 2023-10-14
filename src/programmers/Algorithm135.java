package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 * [카카오 인턴] 수식 최대화
 */

public class Algorithm135 {
    public static void main(String[] args) {

        final String expression = "100-200*300-500+20";
        System.out.println(new Solution().solution(expression));
    }

    static class Solution {

        private String[][] priority = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "+", "-"},
                {"*", "-", "+"},
        };

        public long solution(String expression) {
            long answer = 0;

            List<String> expr = new ArrayList<>();

            int idx = 0;
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '-' || c == '+' || c == '*') {
                    expr.add(expression.substring(idx, i));
                    expr.add(String.valueOf(c));
                    idx = i + 1;
                }
            }
            expr.add(expression.substring(idx));

            for (String[] ops : priority) {
                ArrayList<String> temp = new ArrayList<>(expr);
                for (String op : ops) {

                    for (int i = 0; i < temp.size(); i++) {
                        if (op.equals(temp.get(i))) {
                            temp.set(i - 1, calculate(temp.get(i -1), temp.get(i), temp.get(i + 1)));
                            temp.remove(i);
                            temp.remove(i);
                            i--;
                        }
                    }
                }
                answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
            }

            return answer;
        }

        private String calculate(String num1, String op, String num2) {
            long n1 = Long.parseLong(num1);
            long n2 = Long.parseLong(num2);

            if (op.equals("+"))
                return n1 + n2 + "";
            else if (op.equals("-"))
                return n1 - n2 + "";

            return n1 * n2 + "";
        }
    }
}