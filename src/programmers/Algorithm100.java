package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 * 삼총사
 */

public class Algorithm100 {
    public static void main(String[] args) {
        final int[] number = {-2, 3, 0, 2, -5};

        System.out.println(new Solution().solution(number));
    }

    static class Solution {
        public int solution(int[] number) {
            int answer = 0;

            for (int i = 0; i < number.length - 2; i++) {
                for (int j = i + 1; j < number.length - 1; j++) {
                    for (int k = j + 1; k < number.length; k++) {
                        if (number[i] + number[j] + number[k] == 0) {
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }

    }
}