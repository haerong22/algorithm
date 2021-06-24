
/**
 * https://programmers.co.kr/
 * 예상 대진표
 *
 */

public class Algorithm35 {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 1;
        int left = Math.min(a, b);
        int right = Math.max(a, b);

        while(true) {
            if (left %2 == 1 && (right -left) == 1) {
                break;
            }
            left = (left + 1) / 2;
            right = (right + 1) / 2;
            answer ++;
        }
        return answer;
    }
}
