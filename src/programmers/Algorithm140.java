package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 * 숫자 카드 나누기
 */

public class Algorithm140 {
    public static void main(String[] args) {

        final int[] arrayA = {10, 20};
        final int[] arrayB = {5, 17};
        System.out.println(new Solution().solution(arrayA, arrayB));
    }

    static class Solution {

        public int solution(int[] arrayA, int[] arrayB) {
            int gcdA = getGcd(arrayA);
            int gcdB = getGcd(arrayB);

            return Math.max(getMax(arrayA, gcdB), getMax(arrayB, gcdA));
        }

        private int getMax(int[] array, int num) {
            int max = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % num == 0) break;
                if (i == array.length - 1) max = num;
            }
            return max;
        }

        private int getGcd(int[] array) {
            int gcd = array[0];
            for (int i = 1; i < array.length; i++) {
                gcd = gcd(gcd, array[i]);
            }
            return gcd;
        }

        private int gcd(int a, int b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }
    }
}