package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 비밀지도
 *
 * 1. 지도는 한 변의 길이가`n`인 정사각형 배열 형태로, 각 칸은 공백("") 또는 벽("#") 두 종류로 이루어져 있다.
 * 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각지도1 과 지도2라고 하자.
 *    지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 * 3. 지도 1과지도 2 는 각각 정수 배열로 암호화되어 있다.
 * 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을`1`, 공백 부분을`0`으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 */

public class Algorithm16 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s",Integer.toBinaryString(arr1[i] | arr2[i]))
                    .replaceAll("0", " ").replaceAll("1", "#");
        }
        return answer;
    }
}
