import java.util.Stack;

/**
 * https://programmers.co.kr/
 * 조이스틱
 */

public class Algorithm47 {

    public static void main(String[] args) {
        System.out.println(solution("JAZ"));
    }

    public static int solution(String name) {
        int len = name.length(); // 문자열 길이
        int move = len-1; // 오른쪽으로만 갈 경우 이동 횟수
        int answer = 0 ;

        for(int i=0; i<len; ++i) {
            // 알파벳을 찾는 횟수 (상하 횟수)
            answer += Math.min(name.charAt(i) - 'A', 91 - name.charAt(i));


            // 좌우로 이동시 최소 횟수
            int next = i+1;
            while(next<len && name.charAt(next)=='A') {
                ++next;
            }
            move = Math.min(move,i+len-next+Math.min(i,len-next));
        }
        answer += move;

        return answer;
    }
}
