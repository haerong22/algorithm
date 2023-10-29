package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131130
 * 혼자 놀기의 달인
 */

public class Algorithm150 {
    public static void main(String[] args) {

//        final int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        final int[] cards = {3, 1, 2};

        System.out.println(new Solution().solution(cards));
    }

    static class Solution {

        public int solution(int[] cards) {
            boolean[] open = new boolean[cards.length + 1];

            int a = 0;
            int b = 0;

            for (int i = 1; i <= cards.length; i++) {
                if (open[i]) continue;
                open[i] = true;
                int p = cards[i - 1];
                int cnt = 1;
                while (!open[p]) {
                    cnt++;
                    open[p] = true;
                    p = cards[p - 1];
                }
                System.out.println("cnt = " + cnt);

                if (a > b) {
                    b = Math.max(b, cnt);
                } else {
                    a = Math.max(a, cnt);
                }
            }

            return a * b;
        }
    }
}