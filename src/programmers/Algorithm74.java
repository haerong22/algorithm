package programmers;

import java.util.*;

/**
 * https://programmers.co.kr/
 * 쿼드압축 후 개수 세기
 *
 * ...
 *
 * arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때,
 * 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 *
 * ...
 */

public class Algorithm74 {
    static int one;
    static int zero;

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        comp(arr, 0, 0, arr.length);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }

    public static void comp(int[][] arr, int x, int y, int length) {
        // 숫자 검색하기
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                // 숫자가 다르면 4등분 하기
                if (arr[x][y] != arr[i][j]) {
                    comp(arr, x, y,length/2); // (0, 0) 부터 검색시작
                    comp(arr, x, y+length/2,length/2);  // (0, n) 부터 검색시작
                    comp(arr, x+length/2, y,length/2);  // (n, 0) 부터 검색시작
                    comp(arr, x+length/2, y+length/2,length/2); // (n, n) 부터 검색시작
                    return;
                }
            }
        }
        // 숫자가 다 같을 경우 개수 추가
        if(arr[x][y] == 1) one++;
        else zero++;
    }
}

