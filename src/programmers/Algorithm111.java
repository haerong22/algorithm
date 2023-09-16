package programmers;

import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * 연속 부분 수열 합의 개수
 */

public class Algorithm111 {
    public static void main(String[] args) {

        final int[] elements = {7, 9, 1, 1, 4};
        System.out.println(new Solution().solution(elements));
    }

    static class Solution {

        public int solution(int[] elements) {
            HashSet<Integer> set = new HashSet<>();

            int len = elements.length;
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = 0; j < len; j++) {
                    sum += elements[(i + j) % len];
                    set.add(sum);
                }
            }

            return set.size();
        }
    }
}