package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160585
 * 혼자서 하는 틱택토
 */

public class Algorithm153 {
    public static void main(String[] args) {

        final String[] board = {"O.X", ".O.", "..X"};

        System.out.println(new Solution().solution(board));
    }

    static class Solution {

        public int solution(String[] board) {
            int oCnt = 0;
            int xCnt = 0;

            for (String b : board) {
                for (char c : b.toCharArray()) {
                    if (c == 'O') oCnt++;
                    if (c == 'X') xCnt++;
                }
            }

            if (xCnt == oCnt) {
                if (check(board, 'O')) return 0;
                return 1;
            }
            if (xCnt + 1 == oCnt) {
                if (check(board, 'X')) return 0;
                return 1;
            }

            return 0;
        }

        private boolean check(String[] board, char target) {
            for (int i = 0; i < board.length; i++) {
                if (board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target) return true;

                if (board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target) return true;
            }

            if (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target) return true;
            if (board[2].charAt(0) == target && board[1].charAt(1) == target && board[0].charAt(2) == target) return true;

            return false;
        }

    }
}