package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 * 메뉴 리뉴얼
 */

public class Algorithm130 {
    public static void main(String[] args) {

//        final String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        final int[] course = {2, 3, 4};

//        final String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        final int[] course = {2, 3, 5};

        final String[] orders = {"XYZ", "XWY", "WXA"};
        final int[] course = {2, 3, 4};

        System.out.println(Arrays.toString(new Solution().solution(orders, course)));
    }

    static class Solution {

        public String[] solution(String[] orders, int[] course) {
            List<String> answer = new ArrayList<>();

            for (int i = 0; i < orders.length; i++) {
                char[] o = orders[i].toCharArray();
                Arrays.sort(o);
                orders[i] = String.valueOf(o);
            }

            for (int c : course) {
                Map<String, Integer> map = new HashMap<>();

                for (String order : orders) {
                    combination(map, "", order, c);
                }

                if (!map.isEmpty()) {
                    int max = Collections.max(map.values());
                    map.entrySet().stream()
                            .filter((k) -> k.getValue() > 1  && k.getValue() == max).forEach(k -> answer.add(k.getKey()));
                }
            }

            return answer.stream().sorted().toArray(String[]::new);
        }

        private void combination(Map<String, Integer> map, String order, String others, int count) {

            if (count == 0) {
                map.put(order, map.getOrDefault(order, 0) + 1);
                return;
            }

            for (int i = 0; i < others.length(); i++) {
                combination(map, order + others.charAt(i), others.substring(i + 1), count - 1);
            }
        }

    }
}