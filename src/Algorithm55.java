import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 카펫
 *
 * ...
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */

public class Algorithm55 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int i = 3; i <= Math.sqrt(total); i++) {
            if(total % i == 0) {
                int a = Math.max(total / i, i);
                int b = total / a;
                int tmp = 0;
                while (a >= 3 && b >= 3) {
                    tmp += 2 * (a + b) - 4;
                    if (tmp == brown && total - tmp == yellow) {
                        answer[0] = a;
                        answer[1] = b;
                        return answer;
                    }
                    a -= 2;
                    b -= 2;
                }
            }
        }
        return answer;
    }
}
