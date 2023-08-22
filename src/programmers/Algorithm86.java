package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 * 바탕화면 정리
 */

public class Algorithm86 {
    public static void main(String[] args) {
        final String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        System.out.println(Arrays.toString(new Solution().solution(wallpaper)));
    }

    static class Solution {

        public int[] solution(String[] wallpaper) {
            int row = wallpaper.length;
            int col = wallpaper[0].length();

            int[] answer = {row + 1, col + 1, 0, 0};

            for (int i = 0; i < wallpaper.length; i++) {
                for (int j = 0; j < wallpaper[i].length(); j++) {
                    if (wallpaper[i].charAt(j) == '#') {
                        if (answer[0] > i) {
                            answer[0] = i;
                        }
                        if (answer[1] > j) {
                            answer[1] = j;
                        }
                        if (answer[2] < i + 1) {
                            answer[2] = i + 1;
                        }
                        if (answer[3] < j + 1) {
                            answer[3] = j + 1;
                        }
                    }
                }
            }

            return answer;
        }
    }
}