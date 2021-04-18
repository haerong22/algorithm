/**
 * https://programmers.co.kr/
 * 시저 암호
 *
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 * 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다.z는 1만큼 밀면 a가 됩니다.
 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution 을 완성해 보세요.
 */
public class Algorithm5 {
    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char c = ' ';
        for(int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if(c <= 90 & c >= 65) {
                if (c + n > 90) {
                    answer.append((char) (c + n - 26));
                } else {
                    answer.append((char) (c + n));
                }
            } else if (c >= 97 & c <= 122) {
                if (c + n > 122) {
                    answer.append((char) (c + n - 26));
                } else {
                    answer.append((char) (c + n));
                }
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
