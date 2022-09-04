package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 가장 큰 정사각형 찾기
 *
 * 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
 * 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
 */

public class Algorithm61 {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };
        System.out.println(solution(board));
    }

    public static int solution(int [][]board) {
        int answer = 0;
        if (board.length == 1 && board[0].length == 1) {
            return board[0][0];
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    int min = Math.min(Math.min(board[i-1][j-1], board[i-1][j]), board[i][j-1]);
                    board[i][j] = min + 1;
                    answer = Math.max(min+1, answer);
                }
            }
        }
        return answer * answer;
    }
}
