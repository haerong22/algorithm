import java.util.Arrays;


/**
 * https://programmers.co.kr/
 * 삼각 달팽이
 *
 * 정수 n이 매개변수로 주어집니다.
 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
 * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm41 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }

    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2]; // 1부터 n 까지의 합
        int[][] arr = new int[n][n]; // 값을 담을 배열
        int row = -1, col = 0	, direction = 0, cnt = 1;
        // 방향 n번 반복
        for (int i = 0; i < n; i++) {
            direction = i % 3; // 방향 결정
            for (int j = 0; j < n - i; j++) {
                if(direction == 0) {
                    row++;
                } else if(direction == 1) {
                    col++;
                } else if(direction == 2) {
                    col--;
                    row--;
                }
                arr[row][col] = cnt++;
            }
        }
        cnt = 0;
        // answer 배열에 담기
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[cnt++] = arr[i][j];
            }
        }
        return answer;
    }
}
