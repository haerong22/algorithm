package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 * [3차] 압축
 */

public class Algorithm116 {
    public static void main(String[] args) {

//        final String s = "KAKAO";
        final String s = "TOBEORNOTTOBEORTOBEORNOT";
//        final String s = "ABABABABABABABAB";
        System.out.println(Arrays.toString(new Solution().solution(s)));
    }

    static class Solution {
        public int[] solution(String msg) {
            List<Integer> answer = new ArrayList<>();
            Map<String, Integer> dictionary = new HashMap<>();


            for (int i = 0; i < 26; i++) {
                String key = String.valueOf((char) (65 + i));
                dictionary.put(key, i + 1);
            }

            String w = "";
            int idx = 26;

            for (int i = 0; i < msg.length(); i++) {
                String c = String.valueOf(msg.charAt(i));
                if (dictionary.containsKey(w + c)) {
                    w += c;
                } else {
                    answer.add(dictionary.get(w));
                    dictionary.put(w + c, ++idx);
                    w = c;
                }
            }
            answer.add(dictionary.get(w));

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}