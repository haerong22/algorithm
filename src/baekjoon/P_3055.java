package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/3055
 * <p>
 * 탈출
 */
public class P_3055 {

    static int R, C;
    static String[] forest;
    static int[][] dist_water, dist_hedgehog;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        forest = new String[R];
        dist_water = new int[R][C];
        dist_hedgehog = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            forest[i] = br.readLine();
        }

        bfs_water();

        bfs_hedgehog();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (forest[i].charAt(j) == 'D') {
                    if (dist_hedgehog[i][j] == -1) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
        }
    }

    public static void bfs_water() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist_water[i][j] = -1;
                visited[i][j] = false;
                if (forest[i].charAt(j) == '*') {
                    queue.add(i);
                    queue.add(j);
                    dist_water[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int cx = queue.poll();
            int cy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (forest[nx].charAt(ny) != '.') continue;
                if (visited[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
                dist_water[nx][ny] = dist_water[cx][cy] + 1;
            }
        }

    }

    public static void bfs_hedgehog() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist_hedgehog[i][j] = -1;
                visited[i][j] = false;
                if (forest[i].charAt(j) == 'S') {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                    dist_hedgehog[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int cx = queue.poll();
            int cy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (forest[nx].charAt(ny) != '.' && forest[nx].charAt(ny) != 'D') continue;
                if (visited[nx][ny]) continue;
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[cx][cy] + 1) continue;

                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[cx][cy] + 1;
            }
        }
    }
}