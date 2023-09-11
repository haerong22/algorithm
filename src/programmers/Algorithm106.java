package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 * 연속된 부분 수열의 합
 */

public class Algorithm106 {
    public static void main(String[] args) {

        final int[] sequence = {2, 2, 2, 2, 2};
        final int k = 6;

        System.out.println(Arrays.toString(new Solution().solution(sequence, k)));
    }

    static class Solution {

        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];

            int left = 0;
            int right = 0;
            int sum = 0;
            int size = sequence.length;

            while(left < sequence.length) {
                if(sum > k || right == sequence.length) {
                    sum -= sequence[left++];
                } else {
                    sum += sequence[right++];
                }

                if(sum == k) {
                    if (right - 1 - left < size) {
                        answer[0] = left;
                        answer[1] = right - 1;
                        size = right - 1 - left;
                    }
                }
            }
            return answer;
        }
    }
}