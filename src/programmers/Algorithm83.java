package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 * 공원 산책
 */

public class Algorithm83 {
    public static void main(String[] args) {
        final String[] park = {"OSO", "OOO", "OXO", "OOO"};
        final String[] routes = {"E 2", "S 3", "W 1"};

        System.out.println(Arrays.toString(new Solution().solution(park, routes)));
    }

    static class Solution {

        private String[] park;
        private int[] answer;

        public int[] solution(String[] park, String[] routes) {
            this.park = park;
            this.answer = findStart();

            for (String route : routes) {
                nextStep(route);
            }

            return this.answer;
        }

        public void nextStep(String route) {
            int w = park[0].length();
            int h = park.length;

            String[] split = route.split(" ");

            String direction = split[0];
            int distance = Integer.parseInt(split[1]);

            int x = answer[1];
            int y = answer[0];
            boolean flag = true;

            for (int i = 0; i < distance; i++) {
                if (direction.equals("E")) {
                    x++;
                }
                if (direction.equals("W")) {
                    x--;
                }
                if (direction.equals("S")) {
                    y++;
                }
                if (direction.equals("N")) {
                    y--;
                }

                if (x >= w || x < 0 || y >= h || y < 0 || park[y].charAt(x) == 'X') {
                    flag = false;
                }
            }

            if (flag) {
                answer[0] = y;
                answer[1] = x;
            }
        }

        public int[] findStart() {
            for (int i = 0; i < this.park.length; i++) {
                String s = this.park[i];
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (c == 'S') {
                        return new int[]{i, j};
                    }
                }
            }
            throw new RuntimeException();
        }
    }
}