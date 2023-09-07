package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * 성격 유형 검사하기
 */

public class Algorithm102 {
    public static void main(String[] args) {
        final String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        final int[] choices = {5, 3, 2, 7, 5};

        System.out.println(new Solution().solution(survey, choices));
    }

    static class Solution {

        public String solution(String[] survey, int[] choices) {
            StringBuilder answer = new StringBuilder();

            String type = "RCJATFMN";

            int[] score = new int[4];

            for (int i = 0; i < survey.length; i++) {
                int c = choices[i] - 4;
                int idx = c < 0 ? survey[i].charAt(0) : survey[i].charAt(1);
                int typeIndex = type.indexOf(idx);
                int sign = typeIndex / 4 == 1 ? 1 : -1;
                score[typeIndex % 4] += sign * Math.abs(c);
            }

            for (int i = 0; i < score.length; i++) {
                if (score[i] <= 0) {
                    answer.append(type.charAt(i));
                } else {
                    answer.append(type.charAt(i + 4));
                }
            }

            return answer.toString();
        }
    }
}