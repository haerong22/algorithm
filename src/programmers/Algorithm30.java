package programmers;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://programmers.co.kr/
 * 로또의 최고 순위와 최저 순위
 *
 * ...
 * 민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
 * 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm30 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_numbs = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_numbs)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int min = 0;
        int max = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                max++;
            } else {
                for (int win_num : win_nums) {
                    if (win_num == lotto) {
                        min++;
                        break;
                    }
                }
            }
        }
        answer[0] = max + min < 2 ? 6 : 7 - (max + min);
        answer[1] = min < 2 ? 6 : 7 - min;
        return answer;
    }
}
