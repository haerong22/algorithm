package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978
 * 배달
 */

public class Algorithm139 {
    public static void main(String[] args) {

        final int N = 5;
        final int[][] road = {
                {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
        };
        final int K = 3;
        System.out.println(new Solution().solution(N, road, K));
    }

    static class Solution {

        static class Town {
            int from, to, time;

            public Town(int from, int to, int time) {
                this.from = from;
                this.to = to;
                this.time = time;
            }
        }

        public int solution(int N, int[][] road, int K) {
            int answer = 1;

            List<List<Town>> ways = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                ways.add(new ArrayList<>());
            }

            for (int[] r : road) {
                ways.get(r[0]).add(new Town(r[0], r[1], r[2]));
                ways.get(r[1]).add(new Town(r[1], r[2], r[2]));
            }

            Queue<Town> queue = new LinkedList<>(ways.get(1));

            int[] visited = new int[N + 1];
            Arrays.fill(visited, Integer.MAX_VALUE);
            visited[1] = 0;

            while (!queue.isEmpty()) {
                Town town = queue.poll();

                if (visited[town.to] <= visited[town.from] + town.time) continue;
                visited[town.to] = visited[town.from] + town.time;
                queue.addAll(ways.get(town.to));
            }

            for (int v : visited) {
                if (v <= K) answer++;
            }

            return answer;
        }
    }
}