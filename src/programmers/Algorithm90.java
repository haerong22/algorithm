package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * 개인정보 수집 유효기간
 */

public class Algorithm90 {
    public static void main(String[] args) {
        final String today = "2022.05.19";
        final String[] terms = {"A 6", "B 12", "C 3"};
        final String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(new Solution().solution(today, terms, privacies)));
    }

    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> termsMap = new HashMap<>();
            List<Integer> answer = new ArrayList<>();

            for (String term : terms) {
                String[] s = term.split(" ");
                termsMap.put(s[0], Integer.valueOf(s[1]));
            }

            int todayTimestamp = getTimestamp(today);

            for (int i = 0; i < privacies.length; i++) {
                String privacy = privacies[i];
                String[] s = privacy.split(" ");
                int timestamp = getTimestamp(s[0]);
                if (todayTimestamp - timestamp >= termsMap.get(s[1]) * 28) {
                    answer.add(i + 1);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        private int getTimestamp(String date) {
            String[] s = date.split("\\.");
            return (Integer.parseInt(s[0]) * 12 + Integer.parseInt(s[1])) * 28 + Integer.parseInt(s[2]);
        }
    }

}