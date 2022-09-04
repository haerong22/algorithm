package programmers;

import java.util.Stack;

/**
 * https://programmers.co.kr/
 * 괄호 변환
 *
 * 카카오에 신입 개발자로 입사한콘은 선배 개발자로부터 개발역량 강화를 위해
 * 다른 개발자가 작성한 소스 코드를 분석하여 문제점을 발견하고 수정하라는 업무 과제를 받았습니다.
 * 소스를 컴파일하여 로그를 보니 대부분 소스 코드 내 작성된 괄호가 개수는 맞지만
 * 짝이 맞지 않은 형태로 작성되어 오류가 나는 것을 알게 되었습니다.
 * 수정해야 할 소스 파일이 너무 많아서 고민하던 콘은 소스 코드에 작성된 모든 괄호를 뽑아서
 * 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램을 다음과 같이 개발하려고 합니다.
 */

public class Algorithm46 {

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        String answer = "";
        if(p.equals("")) return answer; // 빈 배열이면 빈 배열 리턴

        int idx = findIdx(p); // u, v로 나눌 인덱스 구하는 메소드
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        // u가 올바른 괄호 문자열인지 체크
        if(check(u)) {
            answer += u + solution(v);
        } else {
            answer += "(" + solution(v) + ")" + reverse(u);
        }
        return answer;
    }
    // 괄호 변환하기
    public static String reverse(String p) {
        String result = "";
        if(p.length() == 2) return result; // 길이가 2이면 빈 문자열 리턴
        String sub = p.substring(1, p.length()-1); // 앞 뒤 괄호 자르기
        for (int i = 0; i < sub.length(); i++) {
            result += sub.charAt(i) == '(' ? ")":"("; // 괄호 뒤집기
        }
        return result;
    }
    // u, v 로 나눌 인덱스 찾는 메소드 ( 균형잡힌 괄호 문자열 )
    public static int findIdx(String p) {
        int cnt = p.charAt(0) == '(' ? 1:-1;
        int idx = p.length();
        for (int i = 1; i < p.length(); i++) {
            if(p.charAt(i) == '(') cnt++;
            else cnt--;
            if(cnt == 0) {
                return i+1;
            }
        }
        return idx;
    }
    // 올바른 괄호 문자열인지 체크하는 메소드
    public static boolean check(String p) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') stack.add(p.charAt(i));
            else if(!stack.isEmpty()) stack.pop();
            else return false;
        }
        return true;
    }
}
