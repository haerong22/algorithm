package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77885
 * 2개 이하로 다른 비트
 */

public class Algorithm127 {
    public static void main(String[] args) {

        final long[] numbers = {2,7};

        System.out.println(Arrays.toString(new Solution().solution(numbers)));
    }

    static class Solution {

        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                String binary = String.format("%17s", Long.toBinaryString(numbers[i])).replace(' ', '0');

                if (binary.endsWith("0")) {
                    answer[i] = numbers[i] + 1;
                } else {
                    int idx = binary.lastIndexOf('0');
                    char[] arr = binary.toCharArray();
                    arr[idx] = '1';
                    arr[idx + 1] = '0';
                    answer[i] = Long.valueOf(String.valueOf(arr), 2);
                }
            }
            return answer;
        }
    }
}