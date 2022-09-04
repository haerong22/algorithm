package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/
 * 피로도
 *
 * ...
 *
 * 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다
 * . 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
 * 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * ...
 */

public class Algorithm72 {

    public static List<int[]> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
                {80, 20}, {50, 40}, {30, 10}
        };
        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        int length = dungeons.length;
        int[] index = new int[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        per(index, 0, length, length);

        for (int[] ints : arrayList) {
            int result = 0;
            int n = k;
            for (int i : ints) {
                if (n >= dungeons[i][0]) {
                    result++;
                    n -= dungeons[i][1];
                } else {
                    break;
                }
            }
            answer = Math.max(answer, result);
        }
        return answer;
    }

    public static void per(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            arrayList.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            per(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
