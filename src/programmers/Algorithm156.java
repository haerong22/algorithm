package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 * 양궁대회
 */

public class Algorithm156 {
    public static void main(String[] args) {

        final int n = 9;
        final int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(new Solution().solution(n, info)));
    }

    static class Solution {

        private int n;
        private int[] apeach;
        private int[] ryan = new int[11];
        private int max = 0;
        private int[] answer = {-1};

        public int[] solution(int n, int[] info) {

            this.n = n;
            this.apeach = info;

            dfs(0, 0);
            return answer;
        }

        private void dfs(int cnt, int depth) {
            if (cnt == n) {
                int diff = compare();
                if (diff > max) {
                    max = diff;
                    answer = ryan.clone();
                } else if (diff == max && check()) {
                    answer = ryan.clone();
                }
                return;
            }

            if (depth == 11) return;

            dfs(cnt, depth + 1);
            int shoot = Math.min(this.apeach[depth] + 1, n - cnt);
            ryan[depth] = shoot;
            dfs(cnt + shoot, depth + 1);
            ryan[depth] = 0;
        }

        private boolean check() {
            for (int i = 10; i >= 0 ; i--) {
                if (answer[i] > ryan[i]) {
                    return false;
                }
                if (answer[i] < ryan[i]) {
                    return true;
                }
            }
            return false;
        }

        private int compare() {
            int apeachScore = 0;
            int ryanScore = 0;

            for (int i = 0; i <= 10; i++) {
                if (apeach[i] == 0 && ryan[i] == 0) continue;

                if (apeach[i] >= ryan[i]) {
                    apeachScore += (10 - i);
                } else {
                    ryanScore += (10 - i);
                }
            }

            return ryanScore - apeachScore <= 0 ? -1 : ryanScore - apeachScore;
        }

    }
}