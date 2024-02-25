package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2251
 * <p>
 * 물통
 */
public class P_2251 {

    static boolean[][][] visited;
    static int[] limit;
    static boolean[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        limit = new int[3];
        visited = new boolean[201][201][201];
        result = new boolean[201];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(s[i]);
        }

        bfs(0, 0, limit[2]);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i]) answer.append(i).append(" ");
        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y, int z) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(new int[]{x, y, z}));
        visited[x][y][z] = true;

        while (!queue.isEmpty()) {
            Node c = queue.poll();
            if (c.point[0] == 0) {
                result[c.point[2]] = true;
            }
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    Node n = c.move(from, to);
                    if (visited[n.point[0]][n.point[1]][n.point[2]]) continue;
                    queue.add(n);
                    visited[n.point[0]][n.point[1]][n.point[2]] = true;
                }
            }
        }
    }

    public static class Node {
        int[] point;

        public Node(int[] p) {
            point = p;
        }

        public Node move(int from, int to) {
            int[] next = new int[]{point[0], point[1], point[2]};
            if (point[from] + point[to] <= limit[to]) {
                next[from] = 0;
                next[to] = point[from] + point[to];
            } else {
                next[from] = point[from] - (limit[to] - point[to]);
                next[to] = limit[to];
            }
            return new Node(next);
        }
    }
}