package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 다트 게임
 */

public class Algorithm18 {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }

    public static int solution(String dartResult) {
        int[] scores = new int[3]; // 각 기회마다 얻은 점수를 담을 배열
        char[] arr = dartResult.toCharArray();
        int index = -1; // scores의 인덱스로 사용
        for (int i = 0; i < arr.length; i++) {
            // 숫자일 때는 scores 배열에 저장
            if(arr[i] >= '0' && arr[i] <= '9') {
                index ++;
                // 10 일 때 조건 추가
                if(arr[i] == '1' && arr[i+1] == '0') {
                    scores[index] = 10;
                    i++;
                } else {
                    scores[index] = arr[i] - 48;
                }
                // D이면 제곱
            } else if(arr[i] == 'D') {
                scores[index] = (int) Math.pow(scores[index], 2);
                // T이면 세제곱
            } else if(arr[i] == 'T') {
                scores[index] = (int) Math.pow(scores[index], 3);
                // * 이면 현재 인덱스와 이전 인덱스 값에 2를 곱한다.
            } else if(arr[i] == '*') {
                scores[index] *= 2;
                // 인덱스가 0일 때
                if(index != 0) scores[index-1] *= 2;
                // # 이면 현재 인덱스에 -1 을 곱한다.
            } else if(arr[i] == '#') {
                scores[index] *= -1;
            }
        }
        return Arrays.stream(scores).sum(); // scores 배열의 합 리턴
    }
}
