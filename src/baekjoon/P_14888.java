package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/14888
 *
 * 연산자 끼워넣기
 */
public class P_14888 {

    static int N, max, min;
    static int[] nums, operators, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operators = new int[4];
        result = new int[N - 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        String[] numArr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numArr[i]);
        }

        String[] operatorArr = br.readLine().split(" ");

        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(operatorArr[i]);
        }

        calculate(0, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate(int k, int value) {
        if (k == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    result[k] = i;

                    int newValue = value;
                    switch (i) {
                        case 0: newValue += nums[k+1]; break;
                        case 1: newValue -= nums[k+1]; break;
                        case 2: newValue *= nums[k+1]; break;
                        case 3: newValue /= nums[k+1]; break;
                    }
                    calculate(k + 1, newValue);
                    operators[i]++;
                    result[k] = 0;
                }
            }
        }
    }
}