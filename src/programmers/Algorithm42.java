package programmers;

import java.util.Arrays;


/**
 * https://programmers.co.kr/
 * 문자열 압축
 *
 * 정수 n이 매개변수로 주어집니다.
 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
 * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm42 {

    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

    public static int solution(String s) {
        int answer = s.length();
        // 1개 부터 n개까지 자르기 반복
        for (int i = 1; i <= s.length()/2; i++) {
            String result = ""; // 압축 결과 담을 변수
            int cnt = 0, j = 0;
            String pre = s.substring(0, i);
            // 주어진 문자열의 길이보다 짧을 때 수행
            while(i + j <= s.length()) {
                String cur = s.substring(j, j + i);
                // 현재 잘라낸 문자열과 이전 잘라낸 문자열 비교
                if(cur.equals(pre)) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        result += cnt + pre;
                    } else {
                        result += pre;
                    }
                    cnt = 1;
                }
                pre = cur;
                j = j+i;
            }
            // 마지막 남은 문자열 더하기
            if(cnt > 1) {
                result += cnt + s.substring(j - i);
            } else {
                result += s.substring(j - i);
            }
            // 길이 비교
            if(result.length() < answer) answer = result.length();
        }
        return answer;
    }
}
