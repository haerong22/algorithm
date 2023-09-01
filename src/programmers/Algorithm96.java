package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 * 푸드 파이트 대회
 */

public class Algorithm96 {
    public static void main(String[] args) {
        final int[] food = {1, 3, 4, 6};

        System.out.println(new Solution().solution(food));
    }

    static class Solution {
        public String solution(int[] food) {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < food.length; i++) {
                for (int j = 0; j < food[i] / 2; j++) {
                    sb.append(i);
                }
            }

            return sb.toString() + 0 + sb.reverse();
        }
    }
}