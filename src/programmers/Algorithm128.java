package programmers;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * 택배상자
 */

public class Algorithm128 {
    public static void main(String[] args) {

        final int[] order = {4, 3, 1, 2, 5};

        System.out.println(new Solution().solution(order));
    }

    static class Solution {

        public int solution(int[] order) {
            int answer = 0;

            Stack<Integer> sub = new Stack<>();

            int idx = 0;

            for (int i = 1; i <= order.length; i++) {
                if (order[idx] == i) {
                    answer++;
                    idx++;

                    while (!sub.isEmpty() && order[idx] == sub.peek()) {
                        answer++;
                        idx++;
                        sub.pop();
                    }
                } else {
                    sub.push(i);
                }
            }

            return answer;
        }
    }
}