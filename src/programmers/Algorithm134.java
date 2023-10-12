package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 호텔 대실
 */

public class Algorithm134 {
    public static void main(String[] args) {

        final String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        System.out.println(new Solution().solution(book_time));
    }

    static class Solution {

        public int solution(String[][] book_time) {
            int[][] time = new int[book_time.length][2];

            for (int i = 0; i < book_time.length; i++) {
                String[] t = book_time[i];
                time[i][0] = toMinute(t[0]);
                time[i][1] = toMinute(t[1]) + 10;
            }

            Arrays.sort(time, (a, b) -> a[0] > b[0] ? 1 : -1);

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int[] t : time) {
                if (queue.size() == 0) {
                    queue.add(t[1]);
                    continue;
                }

                if (queue.peek() <= t[0]) {
                    queue.poll();
                }

                queue.add(t[1]);
            }

            return queue.size();
        }

        private int toMinute(String time) {
            String[] split = time.split(":");
            return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        }
    }
}