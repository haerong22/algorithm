import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/
 * 124 나라의 숫자
 *
 * 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 */

public class Algorithm28 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while(n > 0) {
            int i = n % 3;
            n /= 3;
            if(i == 0) n--;
            answer = num[i] + answer;
        }

        return answer;
    }
}
