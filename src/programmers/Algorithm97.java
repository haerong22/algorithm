package programmers;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * 햄버거 만들기
 */

public class Algorithm97 {
    public static void main(String[] args) {
        final int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(new Solution().solution(ingredient));
    }

    static class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> stack = new Stack<>();

            for (int i : ingredient) {
                stack.push(i);
                int size = stack.size();
                if (size >= 4
                        && stack.get(size - 4) == 1
                        && stack.get(size - 3) == 2
                        && stack.get(size - 2) == 3
                        && stack.get(size - 1) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }

            return answer;
        }
    }
}