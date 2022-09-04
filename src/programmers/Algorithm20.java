package programmers;

import java.util.ArrayList;

/**
 * https://programmers.co.kr/
 * 3진법 뒤집기
 *
 * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후,
 * 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm20 {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    public static int solution(int n) {
        int answer = 0;
        if(n < 3) return n;  // 3미만 일 경우에 바로 리턴
        ArrayList<Integer> reverse = new ArrayList<>();
        // 10진법 -> 3진법으로 변환
        do {
            reverse.add(n % 3);
            n /= 3;
        } while (n >= 3);
        reverse.add(n);
        // 3진법 -> 10진법으로 변환
        for (int i = 0; i < reverse.size(); i++) {
            answer += (reverse.get(i) * Math.pow(3, reverse.size() - i - 1));
        }
        return answer;
    }
}
