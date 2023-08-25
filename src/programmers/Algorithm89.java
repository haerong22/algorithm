package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 * 둘만의 암호
 */

public class Algorithm89 {
    public static void main(String[] args) {
        final String s = "aukks";
        final String skip = "wbqd";
        final int index = 5;

        System.out.println(new Solution().solution(s, skip, index));
    }

    static class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                int idx = 0;
                char c = s.charAt(i);
                while (idx < index) {
                    if (++c > 'z') {
                        c -= 26;
                    }

                    if (!skip.contains(String.valueOf(c))) {
                        idx++;
                    }
                }
                answer.append(c);
            }

            return answer.toString();
        }
    }

}