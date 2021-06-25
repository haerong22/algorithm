
/**
 * https://programmers.co.kr/
 * 다음 큰 숫자
 *
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 *
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 */

public class Algorithm36 {

    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int cnt = getNumbersOfOne(n);
        int next = 0;
        do {
            next = getNumbersOfOne(++n);
        } while (cnt != next);

        return n;
    }
    public static int getNumbersOfOne(int n) {
        int cnt = 0;
        String origin = Integer.toBinaryString(n);
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i)=='1') {
                cnt++;
            }
        }
        return cnt;
    }
}
