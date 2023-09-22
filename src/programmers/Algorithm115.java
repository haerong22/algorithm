package programmers;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * 괄호 회전하기
 */

public class Algorithm115 {
    public static void main(String[] args) {

        final String s = "[](){}";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {

        public int solution(String s) {
            int answer = 0;

            String str = s + s;

            for (int i = 0; i < s.length(); i++) {
                String sub = str.substring(i, i + s.length());
                if (isRight(sub)) {
                    answer++;
                }
            }

            return answer;
        }
        
        private boolean isRight(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '[' || c == '{' || c == '(') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    Character peek = stack.peek();
                    if (c == ']' && peek != '[') break;
                    if (c == '}' && peek != '{') break;
                    if (c == ')' && peek != '(') break;
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
}