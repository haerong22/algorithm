package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250137?language=java
 * [PCCP 기출문제] 1번 / 붕대 감기
 */

public class Algorithm165 {
    public static void main(String[] args) {

        final int[] bandage = {5, 1, 5};
        final int health = 30;
        final int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        System.out.println(new Solution().solution(bandage, health, attacks));
    }

    static class Solution {

        public int solution(int[] bandage, int health, int[][] attacks) {
            int currentHealth = health;
            int attackedTime = 0;
            for (int[] attack : attacks) {
                int term = attack[0] - attackedTime - 1;
                int recoveryAmount = getRecoveryAmount(bandage, term);
                currentHealth = Math.min(health, currentHealth + recoveryAmount);
                currentHealth -= attack[1];
                attackedTime = attack[0];
                if (currentHealth < 0) return -1;
            }

            return currentHealth;
        }
        
        public int getRecoveryAmount(int[] bandage, int term) {
            int q = term / bandage[0];
            int d = term % bandage[0];
            return (q * bandage[0] * bandage[1]) + (q * bandage[2]) + (d * bandage[1]);
        }

    }
}