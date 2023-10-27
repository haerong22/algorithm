package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 * 디펜스 게임
 */

public class Algorithm148 {
    public static void main(String[] args) {

        final int n = 7;
        final int k = 3;
        final int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        System.out.println(new Solution().solution(n, k, enemy));
    }

    static class Solution {

        public int solution(int n, int k, int[] enemy) {
            int answer = 0;

            Queue<Integer> queue = new PriorityQueue<>();

            for (int e : enemy) {
                if (queue.size() == k) {
                    if (e > queue.peek()) {
                        n -= queue.remove();
                        queue.add(e);
                    } else {
                        n -= e;
                    }
                } else {
                    queue.add(e);
                }

                if (n < 0) return answer;

                answer++;
            }

            return answer;
        }
    }
}