package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * 두 큐 합 같게 만들기
 */

public class Algorithm129 {
    public static void main(String[] args) {

        final int[] queue1 = {3, 2, 7, 2};
        final int[] queue2 = {4, 6, 5, 1};

        System.out.println(new Solution().solution(queue1, queue2));
    }

    static class Solution {

        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            long sum1 = 0;
            long sum2 = 0;

            for (int q : queue1) {
                q1.add(q);
                sum1 += q;
            }

            for (int q : queue2) {
                q2.add(q);
                sum2 += q;
            }

            if ((sum1 + sum2) % 2 != 0) return -1;

            long target = (sum1 + sum2) / 2;

            while (sum1 != target) {
                if (answer > (queue1.length + queue2.length) * 2) return -1;

                if (sum1 > target) {
                    Integer poll = q1.poll();
                    q2.add(poll);
                    sum1 -= poll;
                } else {
                    Integer poll = q2.poll();
                    q1.add(poll);
                    sum1 += poll;
                }
                answer++;
            }

            return answer;
        }
    }
}