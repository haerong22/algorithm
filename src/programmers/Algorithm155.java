package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 * 이모티콘 할인행사
 */

public class Algorithm155 {
    public static void main(String[] args) {

        final int[][] users = {
                {40, 10000}, {25, 10000}
        };
        final int[] emoticons = {7000, 9000};

        System.out.println(Arrays.toString(new Solution().solution(users, emoticons)));
    }

    static class Solution {

        private final int[] discount = {10, 20, 30, 40};
        private final int[] answer = new int[2];
        private int[][] users;
        private int[] emoticons;

        public int[] solution(int[][] users, int[] emoticons) {
            this.users = users;
            this.emoticons = emoticons;

            int[] selected = new int[emoticons.length];

            dfs(selected, 0);

            return answer;
        }

        private void dfs(int[] selected, int depth) {
            if (depth == this.emoticons.length) {
                calculate(selected);
            } else {
                for (int d : this.discount) {
                    selected[depth] = d;
                    dfs(selected, depth + 1);
                }
            }
        }

        private void calculate(int[] selected) {
            int totalCnt = 0;
            int totalPrice = 0;

            for (int[] user : this.users) {

                int price = 0;
                for (int i = 0; i < selected.length; i++) {
                    if (user[0] <= selected[i]) {
                        price += emoticons[i] * (100 - selected[i]) / 100;
                    }
                }

                if (price >= user[1]) {
                    totalCnt++;
                } else {
                    totalPrice += price;
                }
            }

            if (totalCnt > this.answer[0]) {
                this.answer[0] = totalCnt;
                this.answer[1] = totalPrice;
            }

            if (totalCnt == this.answer[0] && totalPrice > this.answer[1]) {
                this.answer[1] = totalPrice;
            }
        }

    }
}