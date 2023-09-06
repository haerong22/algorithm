package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * 숫자 짝꿍
 */

public class Algorithm101 {
    public static void main(String[] args) {
        final String X = "12321";
        final String Y = "42531";

        System.out.println(new Solution().solution(X, Y));
    }

    static class Solution {

        public String solution(String X, String Y) {
            int[] x = new int[10];
            int[] y = new int[10];

            for (int i = 0; i < X.length(); i++) {
                int idx = X.charAt(i) - '0';
                x[idx] = x[idx] + 1;
            }

            for (int i = 0; i < Y.length(); i++) {
                int idx = Y.charAt(i) - '0';
                y[idx] = y[idx] + 1;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 9; i >= 0 ; i--) {
                for (int j = 0; j < Math.min(x[i], y[i]); j++) {
                    sb.append(i);
                }
            }

            String answer = sb.toString();

            if (answer.length() == 0) {
                return "-1";
            } else if (answer.startsWith("0")) {
                return "0";
            } else {
                return answer;
            }
        }
    }
}