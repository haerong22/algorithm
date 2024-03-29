package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 주식가격
 *
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 */

public class Algorithm23 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                cnt ++;
                if(prices[i] > prices[j]) break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
