package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * 옹알이 (2)
 */

public class Algorithm98 {
    public static void main(String[] args) {
        final String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(new Solution().solution(babbling));
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            for (String b : babbling) {
                if (b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) continue;

                if (b.replace("aya", "")
                        .replace("ye", "")
                        .replace("woo", "")
                        .replace("ma", "")
                        .replace(" ", "").length() == 0) {
                    answer++;
                }
            }

            return answer;
        }
    }
}