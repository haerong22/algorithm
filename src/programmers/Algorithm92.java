package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 * 문자열 나누기
 */

public class Algorithm92 {
    public static void main(String[] args) {
        final String s = "banana";

        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;

            char target = s.charAt(0);
            int same = 0;
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (same == diff) {
                    target = c;
                    answer++;
                }

                if (c == target) {
                    same++;
                } else {
                    diff++;
                }
            }

            return answer;
        }
    }

}