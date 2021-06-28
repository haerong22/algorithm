import java.util.Arrays;


/**
 * https://programmers.co.kr/
 * 행렬의 곱셈
 *
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 */

public class Algorithm39 {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };

        int[][] arr2 = {
                {3, 3},
                {3, 3}
        };
        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        return answer;
    }
}
