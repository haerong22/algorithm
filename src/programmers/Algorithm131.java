package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 무인도 여행
 */

public class Algorithm131 {
    public static void main(String[] args) {

        final String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};

        System.out.println(Arrays.toString(new Solution().solution(maps)));
    }

    static class Solution {
        private final int[] dx = {1, 0, -1, 0};
        private final int[] dy = {0, 1, 0, -1};

        public int[] solution(String[] maps) {
            List<Integer> answer = new ArrayList<>();

            boolean[][] visited = new boolean[maps.length][maps[0].length()];
            char[][] mapsArr = new char[maps.length][maps[0].length()];

            for (int i = 0; i < maps.length; i++) {
                mapsArr[i] = maps[i].toCharArray();
            }

            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[0].length(); j++) {
                    if (!visited[i][j] && mapsArr[i][j] != 'X') {
                        answer.add(bfs(mapsArr, visited, i, j));
                    }
                }
            }

            return answer.size() == 0 ? new int[]{-1} :answer.stream().sorted().mapToInt(Integer::intValue).toArray();
        }

        private int bfs(char[][] mapsArr, boolean[][] visited, int x, int y) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});
            visited[x][y] = true;

            int sum = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.remove();
                int cx = current[0];
                int cy = current[1];

                sum += Character.getNumericValue(mapsArr[cx][cy]);

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || nx >= mapsArr.length || ny < 0 || ny >= mapsArr[0].length) {
                        continue;
                    }

                    if (!visited[nx][ny] && mapsArr[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }

            return sum;
        }

    }
}