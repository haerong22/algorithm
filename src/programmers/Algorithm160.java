package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 * 택배 배달과 수거하기
 */

public class Algorithm160 {
    public static void main(String[] args) {

        final int cap = 4;
        final int n = 5;
        final int[] deliveries = {1, 0, 3, 1, 2};
        final int[] pickups = {0, 3, 0, 4, 0};

        System.out.println(new Solution().solution(cap, n, deliveries, pickups));
    }

    static class Solution {

        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;

            int delivery = 0;
            int pickup = 0;

            for (int i = n - 1; i >= 0 ; i--) {
                delivery -= deliveries[i];
                pickup -= pickups[i];

                while (delivery < 0 || pickup < 0) {
                    delivery += cap;
                    pickup += cap;
                    answer += (i + 1) * 2L;
                }
            }

            return answer;
        }

    }
}