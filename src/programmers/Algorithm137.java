package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * 마법의 엘리베이터
 */

public class Algorithm137 {
    public static void main(String[] args) {

        final int storey = 2554;
        System.out.println(new Solution().solution(storey));
    }

    static class Solution {

        public int solution(int storey) {
            int answer = 0;

            String str = String.valueOf(storey);

            int temp = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                int v = Character.getNumericValue(str.charAt(i)) + temp;

                if (v > 5) {
                    answer += 10 - v;

                    if (i == 0) answer++;
                    else temp = 1;
                } else {
                    temp = 0;

                    if (i != 0 && v == 5) {
                        int n = Character.getNumericValue(str.charAt(i - 1));
                        if (n >= 5) temp = 1;
                    }

                    answer += v;
                }
            }

            return answer;
        }
    }
}