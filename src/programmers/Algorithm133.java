package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * 전력망을 둘로 나누기
 */

public class Algorithm133 {
    public static void main(String[] args) {

        final int n = 9;
        final int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        System.out.println(new Solution().solution(n, wires));
    }

    static class Solution {

        private int[][] graph;

        public int solution(int n, int[][] wires) {
            int answer = n;

            graph = new int[n + 1][n + 1];

            for (int[] wire : wires) {
                int from = wire[0];
                int to = wire[1];
                connect(from, to);
            }

            for (int[] wire : wires) {
                int from = wire[0];
                int to = wire[1];
                disconnect(from, to);

                answer = Math.min(answer, bfs(n, from));
                connect(from, to);
            }

            return answer;
        }

        private void connect(int from, int to) {
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        private void disconnect(int from, int to) {
            graph[from][to] = 0;
            graph[to][from] = 0;
        }

        private int bfs(int n, int start) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            visited[start] = true;
            int cnt = 1;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int i = 0; i <= n; i++) {
                    if (graph[current][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                        cnt++;
                    }
                }
            }

            return Math.abs(cnt - (n-cnt));
        }
    }
}