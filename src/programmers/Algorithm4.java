package programmers;

/**
 * https://programmers.co.kr/
 * 문자열을 정수로 바꾸기
 *
 * 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution 을 완성하세요.
 */
public class Algorithm4 {
    public static void main(String[] args) {
        System.out.println(solution("1234"));
    }

    public static int solution(String s) {
        int answer = 0;
        String str = s.charAt(0) == '-' || s.charAt(0) == '+' ? s.substring(1) : s;
        for(int i=0; i<str.length(); i++) {
            answer += (str.charAt(str.length()-1-i) - 48) * Math.pow(10, i);
        }

        return s.charAt(0) == '-' ? -answer : answer;
    }
}
