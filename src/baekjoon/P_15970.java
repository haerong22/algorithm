package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/15970
 *
 * 화살표 그리기
 */
public class P_15970 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] arr = new ArrayList[N + 1];

        for (int i = 1; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int idx = Integer.parseInt(split[0]);
            int color = Integer.parseInt(split[1]);
            arr[color].add(idx);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }
        
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;

            for (int j = 0; j < arr[i].size(); j++) {

                if (j == 0) {
                    right = arr[i].get(j + 1) - arr[i].get(j);
                } else if (j == arr[i].size() - 1){
                    left = arr[i].get(j) - arr[i].get(j - 1);
                } else {
                    right = arr[i].get(j + 1) - arr[i].get(j);
                    left = arr[i].get(j) - arr[i].get(j - 1);
                }

                answer += Math.min(left, right);
            }
        }

        System.out.println(answer);
    }

}