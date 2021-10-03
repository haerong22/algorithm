import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 최소직사각형
 *
 * ...
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm69 {

    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                w = Math.max(w, size[0]);
                h = Math.max(h, size[1]);
            } else {
                w = Math.max(w, size[1]);
                h = Math.max(h, size[0]);
            }
        }
        return w * h;
    }
}
