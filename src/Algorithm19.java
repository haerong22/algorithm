import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 키패드 누르기
 */

public class Algorithm19 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        // 왼손 오른손의 초기 좌표
        int[] left = {3, 0}, right = {3, 2};
        // 좌표 초기화
        int x = 0, y = 0;
        for (int i : numbers) {
            int h = 0; // 왼손 인지 오른손 인지 판단할 변수(0: 왼손 , 1: 오른손)
            if(i == 0) i = 11; // 0 일경우 11로 변경
            // 현재 숫자의 좌표
            x = (i-1)/3;
            y = (i-1)%3;
            if (i % 3 == 0) { // 3, 6, 9 일 경우 오른손
                h = 1;
            } else if(i % 3 == 2) { // 2, 5, 8, 0(11) 일 경우
                // 오른손, 왼손 위치와 현재 좌표의 거리 비교
                if(Math.abs(left[0] - x) + Math.abs(left[1] - y)
                        > Math.abs(right[0] - x) + Math.abs(right[1] - y)) {
                    h = 1;
                    // 거리가 같을 경우
                } else if (Math.abs(left[0] - x) + Math.abs(left[1] - y)
                        == Math.abs(right[0] - x) + Math.abs(right[1] - y)){
                    // 오른손 잡이일 경우
                    if(hand.equals("right")) h = 1;
                }
            }
            // 왼손일 경우
            if(h == 0) {
                answer += "L";
                left[0] = x;
                left[1] = y;
                // 오른손일 경우
            } else {
                answer += "R";
                right[0] = x;
                right[1] = y;
            }
        }
        return answer;
    }
}
