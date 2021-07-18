import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://programmers.co.kr/
 * 큰 수 만들기
 *
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 */

public class Algorithm45 {

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        String answer = "";
        if(k == 0) return answer + number; // k가 0일때 리턴
        if(number.length() == k) return answer; // k가 0이아니고 주어진 문자열 길이와 같을 때 리턴
        int max = 0, idx = 0;
        // 왼쪽부터 가장 큰 수 검색
        for (int i = 0; i <= k; i++) {
            if(number.charAt(i) > max) {
                max = number.charAt(i);
                idx = i;
            }
        }
        answer += max - 48; // 정답배열 추가
        return answer += solution(number.substring(idx + 1), k-idx);
    }
}
