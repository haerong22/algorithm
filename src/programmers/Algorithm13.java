package programmers;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * https://programmers.co.kr/
 * 크레인 인형뽑기 게임
 *
 * 2019 카카오 개발자 겨울 인턴십
 */

public class Algorithm13 {
    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }

    public static int solution ( int[][] board, int[] moves){
        int answer = 0;
        // 결과를 담을 stack 생성
        Stack<Integer> result = new Stack<>();
        // 초기값은 0으로 주고 시작
        result.push(0);
        // 인형을 꺼내올 위치를 하나씩 꺼내온다
        for (int move : moves) {
            // 각 배열을 돌면서 꺼내온 위치에 있는 값을 찾는 반복문
            for (int i = 0; i < board.length; i++) {
                // 꺼내온 값이 0이 아닐 때 수행
                if (board[i][move - 1] != 0) {
                    // 결과를 담은 스택에 마지막 값이 꺼내온 값과 같으면
                    if (result.peek() == board[i][move - 1]) {
                        // 스택의 마지막 값을 꺼내고 인형 두마리 추가~
                        result.pop();
                        answer += 2;
                    } else {
                        // 값이 다르면 스택에 추가
                        result.push(board[i][move - 1]);
                    }
                    // 인형을 꺼내서 스택에 담았기 때문에 꺼내온 위치의 값을 0으로 바꿔준다.
                    board[i][move - 1] = 0;
                    // 한번 수행을 했기 때문에 반복문을 종료.
                    break;
                }
            }
        }
        return answer;
    }
}
