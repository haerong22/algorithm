package programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 뒤에 있는 큰 수 찾기
 */

public class Algorithm121 {
    public static void main(String[] args) {

        final int[] numbers = {2, 3, 3, 5};

        System.out.println(Arrays.toString(new Solution().solution(numbers)));
    }

    static class Solution {

        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 1; i < numbers.length; i++) {

                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }

            return answer;
        }
    }
}