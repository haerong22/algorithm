package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 주차 요금 계산
 */

public class Algorithm118 {
    public static void main(String[] args) {

//        final int[] fees = {180, 5000, 10, 600};
//        final String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        final int[] fees = {120, 0, 60, 591};
        final String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        System.out.println(Arrays.toString(new Solution().solution(fees, records)));
    }

    static class Solution {

        public int[] solution(int[] fees, String[] records) {

            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> answer = new HashMap<>();

            for (String record : records) {
                String[] s = record.split(" ");
                int key = Integer.parseInt(s[1]);
                if (s[2].equals("IN")) {
                    map.put(key, toMinute(s[0]));
                } else {
                    int time = toMinute(s[0]) - map.get(key);
                    answer.put(key, answer.getOrDefault(key, 0) + time);
                    map.remove(key);
                }
            }

            map.forEach((k, v) -> {
                int time = toMinute("23:59") - map.get(k);
                answer.put(k, answer.getOrDefault(k, 0) + time);
            });

            return answer.keySet().stream().sorted().mapToInt(v -> {
                Integer use = answer.get(v);
                if (use > fees[0]) {
                    return fees[1] + (int) Math.ceil((double) (use - fees[0]) / fees[2]) * fees[3];
                }
                return fees[1];
            }).toArray();
        }

        private int toMinute(String time) {
            String[] s = time.split(":");
            return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        }
    }
}