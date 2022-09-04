package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/
 * 카카오 프렌즈 컬러링북
 *
 */

public class Algorithm38 {

    public static void main(String[] args) {
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        System.out.println(Arrays.toString(solution(6, 4, picture)));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        // 방문했던 노드 체크하기 위한 배열
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 값이 0이거나 방문한 경우 제외
                if(picture[i][j] != 0 && !visited[i][j]) {
                    int cnt = 0; // 그림 영역의 크기를 셀 변수
                    int v = picture[i][j];
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                    answer[0]++; // 그림영역 추가
                    cnt ++;
                    // 빈 큐가 될때까지 반복
                    while(!q.isEmpty()) {
                        Node node = q.poll();
                        // 인접 노드들이 있는지 체크하고 있으면 큐에 넣는다.
                        if(node.x < m - 1 && picture[node.x + 1][node.y] == v && !visited[node.x + 1][node.y]) {
                            q.offer(new Node(node.x + 1, node.y));
                            visited[node.x + 1][node.y] = true;
                            cnt++;
                        }
                        if(node.x > 0 && picture[node.x - 1][node.y] == v && !visited[node.x - 1][node.y]) {
                            q.offer(new Node(node.x - 1, node.y));
                            visited[node.x - 1][node.y] = true;
                            cnt++;
                        }
                        if(node.y > 0 && picture[node.x][node.y - 1] == v && !visited[node.x][node.y - 1]) {
                            q.offer(new Node(node.x, node.y - 1));
                            visited[node.x][node.y - 1] = true;
                            cnt++;
                        }
                        if(node.y < n - 1 && picture[node.x][node.y + 1] == v && !visited[node.x][node.y + 1]) {
                            q.offer(new Node(node.x, node.y + 1));
                            visited[node.x][node.y + 1] = true;
                            cnt++;
                        }
                    }
                    if(answer[1] < cnt) answer[1] = cnt;
                }
            }
        }
        return answer;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
