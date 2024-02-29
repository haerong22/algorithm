package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250125
 *
 * [PCCE 기출문제] 9번 / 이웃한 칸
 */
public class Algorithm166 {
    public static void main(String[] args) {

        String[][] board = {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}
        };

        int h = 1;
        int w = 1;

        System.out.println(new Solution().solution(board, h, w));
    }

    static class Solution {

        public int solution(String[][] board, int h, int w) {
            int answer = 0;

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nx = h + dx[i];
                int ny = w + dy[i];

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;

                if (board[h][w].equals(board[nx][ny])) {
                    answer++;
                }
            }

            return answer;
        }

    }
}