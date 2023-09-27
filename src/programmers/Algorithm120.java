package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 * 방문 길이
 */

public class Algorithm120 {
    public static void main(String[] args) {

        final String dirs = "RRRRRLLLLL";

        System.out.println(new Solution().solution(dirs));
    }

    static class Solution {

        public int solution(String dirs) {
            int answer = 0;

            int[][][] visited = new int[11][11][4];

            int x = 5;
            int y = 5;
            int cd = 0;
            int d = 0;

            for (char c : dirs.toCharArray()) {
                int nx = x;
                int ny = y;

                if (c == 'U') {
                    ny++;
                    d = 0;
                    cd = 1;
                } else if (c == 'D') {
                    ny--;
                    d = 1;
                    cd = 0;
                } else if (c == 'L') {
                    nx--;
                    d = 2;
                    cd = 3;
                } else if (c == 'R') {
                    nx++;
                    d = 3;
                    cd = 2;
                }

                if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) {
                    continue;
                }

                if (visited[x][y][d] == 0) {
                    answer++;
                    visited[x][y][d] = 1;
                    visited[nx][ny][cd] = 1;
                }

                x = nx;
                y = ny;
            }

            return answer;
        }
    }
}