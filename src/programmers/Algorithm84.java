package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 * 크기가 작은 부분문자열
 */

public class Algorithm84 {
    public static void main(String[] args) {
        final String t = "3141592";
        final String p = "271";

        System.out.println(new Solution().solution(t, p));
    }

    static class Solution {

        public int solution(String t, String p) {
            int answer = 0;

            int len = p.length();

            for (int i = 0; i <= t.length() - len; i++) {
                if (Long.parseLong(t.substring(i, i + len)) <= Long.parseLong(p)) {
                    answer++;
                }
            }

            return answer;
        }
    }
}