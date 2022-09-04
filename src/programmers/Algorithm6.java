package programmers;

/**
 * https://programmers.co.kr/
 * 핸드폰 번호 가리기
 *
 * 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
 * 전화번호가 문자열 phone_number 로 주어졌을 때,
 * 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution 을 완성해주세요.
 */

public class Algorithm6 {
    public static void main(String[] args) {
        System.out.println(solution("1033334444"));
    }

    public static String solution(String phone_number) {
        String answer = "";
        StringBuilder star = new StringBuilder();
        for(int i=0; i<phone_number.length()-4;i++) {
            star.append("*");
        }
        answer += phone_number.replace(phone_number.substring(0, phone_number.length()-4), star.toString());
        return answer;
    }
}
