package programmers;

/**
 * https://programmers.co.kr/
 * JadenCase 문자열 만들기
 *
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 */

public class Algorithm60 {

    public static void main(String[] args) {
        System.out.println(solution("3people  unFollowed me  "));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.toLowerCase().split("");
        boolean flag = true;

        for(String word : words) {
            answer.append(flag ? word.toUpperCase() : word);
            flag = word.equals(" ");
        }

        return answer.toString();
    }
}
