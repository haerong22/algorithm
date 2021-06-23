import java.util.Stack;

/**
 * https://programmers.co.kr/
 * 짝지어 제거하기
 *
 * ...
 *
 * 예를 들어, 문자열 S = baabaa 라면
 * b aa baa → bb aa → aa →
 * 의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
 */

public class Algorithm34 {

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
