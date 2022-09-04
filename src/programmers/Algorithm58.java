package programmers;

/**
 * https://programmers.co.kr/
 * 숫자의 표현
 *
 * 1 + 2 + 3 + 4 + 5 = 15
 * 4 + 5 + 6 = 15
 * 7 + 8 = 15
 * 15 = 15
 * 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 */

public class Algorithm58 {

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 1;
        for (int i = 1; i < n; i++) {
            int sum = i;
            for (int j = i+1; j < n ; j++) {
                sum += j;
                if (sum == n) answer++;
                if (sum > n) break;
            }
        }
        return answer;
    }
}
