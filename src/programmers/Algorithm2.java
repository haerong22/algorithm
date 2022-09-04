package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 문자열 내 마음대로 정렬하기
 *
 * 문자열로 구성된 리스트 strings 와, 정수 n이 주어졌을 때,
 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
 * 예를 들어 strings 가 [sun,bed,car]이고 n이 1이면
 * 각 단어의 인덱스 1의 문자 u,e,a 로 strings 를 정렬합니다.
 */
public class Algorithm2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
    }

    public static String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .map(str -> str.charAt(n) + str)
                .sorted()
                .map(str -> str.substring(1)).toArray(String[]::new);
    }
}
