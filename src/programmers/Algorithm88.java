package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 * 카드 뭉치
 */

public class Algorithm88 {
    public static void main(String[] args) {
        final String[] card1 = {"i", "drink", "water"};
        final String[] card2 = {"want", "to"};
        final String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(new Solution().solution(card1, card2, goal));
    }

    static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String result = "Yes";

            int idx1 = 0;
            int idx2 = 0;

            for (String s : goal) {
                if (idx1 < cards1.length && cards1[idx1].equals(s)) {
                    idx1++;
                    continue;
                }
                if (idx2 < cards2.length && cards2[idx2].equals(s)) {
                    idx2++;
                    continue;
                }
                result = "No";
                break;
            }

            return result;
        }
    }

}